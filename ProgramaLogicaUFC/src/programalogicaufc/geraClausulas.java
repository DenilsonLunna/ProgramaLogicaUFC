/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalogicaufc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Max
 */
public class geraClausulas {

    private List<String> clausulas = new ArrayList<>();
    public  Map<String, Integer> mp = new HashMap<String, Integer>();
    public ArrayList<String> literais = new ArrayList<>();
    private ArrayList<String> fncs = new ArrayList<>();
    
   
    public List<String> geraListaDeClausulas(List<Integer>[] vertices, int cor) {

        if (cor == 1 && vertices.length > 1) {
            return null;
        } else {
            for (int i = 1; i < vertices.length; i++) {
                for (int j = 1; j <= cor; j++) {
                    for (int k = 1; k <= cor; k++) {
                        if (k == j) {
                            continue;
                        }
                        clausulas.add("-" + Integer.toString(i) + "_" + j + "v" + "-" + i + "_" + k);
                    }
                }
            }
            
            for (int i = 1; i < vertices.length; i++) {
                String aux = "";
                for (int j = 1; j <= cor; j++) {
                    if (j < cor) {
                        aux += i + "_" + j + "v";
                        literais.add(i + "_" + j);
                    } else {
                        aux += i + "_" + j;
                        literais.add(i + "_" + j);
                    }
                }
                clausulas.add(aux);
            }

            for (int i = 1; i < vertices.length; i++) {
                List<Integer> aux = vertices[i];
                for (int j = 1; j <= cor; j++) {
                    for (int k = 0; k < aux.size(); k++) {
                        clausulas.add("-" + Integer.toString(i) + "_" + j + "v" + "-" + aux.get(k) + "_" + j);
                    }
                }
            }
        }

        System.out.println("Hashmaps --------------------------------------------");
        for (int i = 0; i < literais.size(); i++) {
            mp.put(literais.get(i), i + 1);
       
            System.out.println(mp.get(literais.get(i)));
        }

        System.out.println("Cláusulas --------------------------------------------");
        for (String clausula : clausulas) {
            System.out.println(clausula);
        }

        converteClausulaFNC();
        return null;
    }

    public void converteClausulaFNC() {
        for (int j = 0; j < clausulas.size(); j++) {
            String[] str = clausulas.get(j).split("v");

            String fnc = "";
            for (int i = 0; i < str.length; i++) {
                if (str[i].charAt(0) == '-') {
                    String[] split = str[i].split("-");
                    fnc += "" + (mp.get(split[1]) * -1) + " ";
                } else {
                    fnc += "" + (mp.get(str[i])) + " ";
                }
            }

            fnc += " 0";
            fncs.add(fnc);
        }

        fncs.add(0, "p cnf " + literais.size() + " " + clausulas.size());
        System.out.println("fncs ---------------------------------------");
        for (String l : fncs) {
            System.out.println(l);
        }
    }

    public ArrayList<String> getFncs() {
        return fncs;
    }
}
