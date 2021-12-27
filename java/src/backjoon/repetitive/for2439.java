
package backjoon.repetitive;

import java.util.*;

public class for2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개의 별을 찍을까요? ");
        int n = sc.nextInt();
        sc.close();

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(j <= n-i){
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }




    }

}

