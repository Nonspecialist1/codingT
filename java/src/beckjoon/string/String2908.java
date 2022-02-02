
package beckjoon.string;

import java.util.Scanner;

public class String2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        char[] arr1 = String.valueOf(a).toCharArray();
        char[] arr2 = String.valueOf(b).toCharArray();
        char c = '0';

        c = arr1[0];
        arr1[0] = arr1[2];
        arr1[2] = c;

        c = arr2[0];
        arr2[0] = arr2[2];
        arr2[2] = c;

        String str1 = new String(arr1);
        String str2 = new String(arr2);

        int x = Integer.parseInt(str1);
        int y = Integer.parseInt(str2);
        if(x > y){
            System.out.println(x);
        }else {
            System.out.println(y);
        }
    }
}

