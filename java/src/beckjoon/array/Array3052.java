
package beckjoon.array;

import java.util.Scanner;
public class Array3052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[42];

        for(int i = 0 ; i < 10 ; i++) {
            arr[sc.nextInt() % 42] = true;
        }

        int count = 0;
        for(boolean value : arr) {
            if(value){    // value 가 true 라면
                count++;
            }
        }
        System.out.println(count);
    }
}
