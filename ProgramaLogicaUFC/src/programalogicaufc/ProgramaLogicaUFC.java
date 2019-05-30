/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalogicaufc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denilson
 */
public class ProgramaLogicaUFC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TransformarArquivo trans = new TransformarArquivo("Instancias\\myciel1.col");
        List<Integer>[] grafo = trans.transformarEmListaA();
        geraClausulas gera = new geraClausulas();
        gera.geraListaDeClausulas(grafo, 2);
        TratarArquivo ta = new TratarArquivo();
        ta.escreverArquivo("myciel1_SAT.txt", gera.getFncs());

        //o vertice 0 é ignorado, começa direto do vertice 1, só para facilitar o entendimento
        for (int i = 1; i < grafo.length; i++) {
            System.out.println("Vizinhos do vertice " + i);
            for (Integer integer : grafo[i]) {
                System.out.println(integer);
            }

        }
    }

}
