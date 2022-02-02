
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String5622 {
    public static void main(String[] args) throws IOException {
        int[] num = new int[15];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            int var = str.charAt(i);
            num[i] = var;
        }

        int total = 0;
        for(int i=0; i<num.length; i++){
            int y = 0;
            if(num[i] > 0){
                int x = num[i];
                if(x < 68){
                    y = 3;
                } else if(x < 71){
                    y = 4;
                } else if(x < 74){
                    y = 5;
                } else if(x < 77){
                    y = 6;
                } else if(x < 80){
                    y = 7;
                } else if(x < 84){
                    y = 8;
                } else if(x < 87){
                    y = 9;
                } else if(x < 91) {
                    y = 10;
                }
            }
            total += y;
        }

        System.out.println(total);
    }
}

