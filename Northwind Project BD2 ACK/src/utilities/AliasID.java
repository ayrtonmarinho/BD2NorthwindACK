/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author ayrto
 */
public class AliasID {

    //private static String alias;
    public AliasID() {

    }

    public static String generateAliasID(String nome) {
        StringBuilder stb = new StringBuilder();
        if (noSpaceString(nome)) {
            nome = nome.substring(0, 5).toUpperCase();
        } else {
            String[] one = nome.split("\\s");
            if (one[0].length() > 4) {
                nome = one[0].substring(0, 4) + one[1].substring(0);
                nome = nome.substring(0, 5).toUpperCase();
            } else {
                for (int i = 0; i < one.length; i++) {
                    stb.append(one[i].substring(0, one[i].length()));
                }
                //nome = one[0].substring(0, one[0].length()) + one[1];
                nome = stb.toString();
                nome = nome.substring(0, 5).toUpperCase();
                System.out.println("Aqui");
            }
            //nome = String.valueOf(tag).toUpperCase();

        }
        return nome;

    }

    private static Boolean noSpaceString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }
}
