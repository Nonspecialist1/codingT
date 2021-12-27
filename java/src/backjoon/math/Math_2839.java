package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 4 || n == 7){ System.out.println(-1); }
        for (int i=0; i< 1667; i++) {
            for(int j=0; j<1001; j++){
                    if(n < (5*j) + (3*i)){break;}
                    if(n == (5*j) + (3*i)){
                        System.out.println(j+i);
                        return;
                    }
            }
        }
    }
}