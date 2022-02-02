
package beckjoon.repetitive;

import java.util.Scanner;

public class for10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 갯수를 적으시오 : ");
        int n = sc.nextInt();
        System.out.println();
        System.out.print("비교할 정수를 적으시오 : ");
        int x = sc.nextInt();

        int[] a = new int[n];
        System.out.print("들어갈 숫자를 적으시오 : ");
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            if(a[i] < x){
                System.out.print(a[i] + " ");
            }
        }



    }
}

