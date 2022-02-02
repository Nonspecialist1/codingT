
package beckjoon.string;

import java.util.Scanner;

public class String2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("dz=|c=|c-|d-|lj|nj|s=|z=", "x");

        /*
        String text = str.replace("lj", "a");
        String text1 = text.replace("c=", "a");
        String text2 = text1.replace("c-", "a");
        String text3 = text2.replace("dz=", "a");
        String text4 = text3.replace("d-", "a");
        String text5 = text4.replace("nj", "a");
        String text6 = text5.replace("s=", "a");
        String text7 = text6.replace("z=", "a");
        */

        System.out.println(str.length());
    }
}

