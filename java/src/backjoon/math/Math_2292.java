
package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[18258];
        int x = 1;
        for(int i =0; i<arr.length; i++){
            x += (6*i);
            arr[i] = x;
            if(N <= arr[i]){
                System.out.println(i+1);
                return;
            }
        }
    }
}
