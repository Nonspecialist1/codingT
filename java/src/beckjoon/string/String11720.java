
package beckjoon.string;

import java.util.Scanner;

public class String11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = new char[sc.nextInt()];
        String str = sc.next();
        int total = 0;

        for(int i=0; i<ch.length; i++){
            ch[i] = str.charAt(i);
            total += Integer.parseInt(ch[i]+"");
        }
        System.out.println(total);
    }
}

