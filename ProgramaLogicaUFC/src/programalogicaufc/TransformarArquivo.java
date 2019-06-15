/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalogicaufc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Denilson
 */
public class TransformarArquivo {

    public int qtdVertices;
    public ArrayList<String> arquivo;
    public List<Integer>[] grafo;

    public TransformarArquivo(String caminho) {
        qtdVertices = 0;
        TratarArquivo ta = new TratarArquivo();
        this.arquivo = ta.lerArquivo(caminho);
    }

    public List<Integer>[] transformarEmListaA() {
        if (arquivo != null) {
            //pegando quantidade de vertices e arestas do grafo

            String[] linhaQuebrada = arquivo.get(0).split(" ");
            qtdVertices = Integer.parseInt(linhaQuebrada[2]);

            //construindo grafo =============================================
            //inicializando grafo - Lista de adgecência
            grafo = new LinkedList[qtdVertices + 1];
            for (int j = 0; j < grafo.length; j++) {
                grafo[j] = new LinkedList<Integer>();
            }
            for (int i = 1; i < arquivo.size(); i++) {
                linhaQuebrada = arquivo.get(i).split(" ");
                int verticeAtual = Integer.parseInt(linhaQuebrada[1]);
                int vizinhoDoVerticeAtual = Integer.parseInt(linhaQuebrada[2]);
                this.grafo[verticeAtual].add(vizinhoDoVerticeAtual);
                this.grafo[vizinhoDoVerticeAtual].add(verticeAtual);

            }
        }
        return grafo;
    }

    public List<Integer>[] transformarEmListaA(ArrayList<String> arquivo) {
        this.arquivo = arquivo;
        return this.transformarEmListaA();

    }
    
    public void gerarValoracao(ArrayList<String> valor, geraClausulas gera, String nomeArquivo){
         String[] valorQuebrado = null;
         ArrayList<Integer> lista = new ArrayList<>();

        for (String string : valor) {
            valorQuebrado = string.split(" ");
            
            for (int i = 0; i < valorQuebrado.length; i++) {
                System.out.println(valorQuebrado[i]);
                lista.add(Integer.parseInt(valorQuebrado[i]));
                
            }
            
        }
        
        //pegando os numeros positivos da lista
         ArrayList<Integer> numPositivos = new ArrayList<>();
        for (Integer integer : lista) {
            if(integer > 0){
                numPositivos.add(integer);
                
            }
        }
        
        //mapeando no hashmap
        TratarArquivo ta = new TratarArquivo();
        
        ArrayList<String> resultado = new ArrayList<>();
        
        for (Integer numPositivo : numPositivos) {
            
            resultado.add("A clausula: "+gera.literais.get(numPositivo-1)+" e verdadeira");
            
        }
        ta.escreverArquivo(nomeArquivo, resultado);
        
        
       
    }

}
