/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalogicaufc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denilson
 */
public class TratarArquivo {
    
    List<Integer>[] grafo; 
		
    
    public  ArrayList<String> lerArquivo(String caminhoArquivo){
        ArrayList<String> linhas = new ArrayList<>();
        
        
        try {
            FileInputStream arquivo = new FileInputStream(caminhoArquivo);
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);
            String linha = "";
            int pos = 0;
            do{
                linha = br.readLine();
                if(linha != null){
                   linhas.add(linha);
                }
            }while(linha != null);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado : "+ex);
        } catch (IOException ex) {
            Logger.getLogger(TratarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linhas;
    }
    public void escreverArquivo(String nomeArquivo,ArrayList<String> linhas){
        try {
            FileOutputStream arquivotxt = new FileOutputStream("Instancias\\Resultados\\Resultados Concretos\\"+nomeArquivo+".txt");
            PrintWriter pe = new PrintWriter(arquivotxt);
            
            for (int i = 0; i < linhas.size(); i++) {
                pe.println(linhas.get(i));
                
            }
            pe.close();
            arquivotxt.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TratarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TratarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
