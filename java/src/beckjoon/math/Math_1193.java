
package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Math_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] arr;

        int y = 1;
        for(int i=2;;i++){
            if(X <= y){ // 15 == 1, 3, 6, 10, 15
                arr = new int[i-1];
                X = y - X;
                arr[0] = i-1;
                ArrayList<Integer> list = new ArrayList();
                list.add(arr[0]);
                for(int j=1; j<arr.length; j++){
                    arr[j] = i-j-1;
                    list.add(arr[j]);
                }
                Collections.reverse(list);
                if(arr[0] % 2 == 0){
                    System.out.printf("%d/%d", arr[X], list.get(X));
                }else {
                    System.out.printf("%d/%d", list.get(X), arr[X]);
                }
                return;
            }
            y += i; //
        }
    }
}

