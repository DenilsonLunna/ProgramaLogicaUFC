/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalogicaufc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Max
 */
public class teste {

    public static void main(String[] args) {

        String str = "-2_1v-1_1";
        String[] aux = str.split("v");
        System.out.println(aux.length);

        Map<String, Integer> mp = new HashMap<String, Integer>();
        mp.put("1_1", 1);

        for (String string : aux) {
            System.out.println(string);
            String[] aux2 = string.split("-");
            System.out.println(aux2[1]);
            System.out.println(aux[0].charAt(0));
        }
    }

}
