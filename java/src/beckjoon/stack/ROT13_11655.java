package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c > 96){
                c += 13;
                if(c > 122) c-= 26;
            }
            else if (c > 64){
                c += 13;
                if(c > 90) c-= 26;
            }
            arr[i] = c;
        }

        for(char c : arr){ System.out.print(c); }
    }
}
