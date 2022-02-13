package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WordReverse_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 0;
        String[] str = new String[1000*n];

        for(int i=0; i<n; i++){
            StringTokenizer sk = new StringTokenizer(br.readLine());
            while(sk.hasMoreTokens()){
                StringBuilder sb = new StringBuilder();
                sb.append(sk.nextToken());
                sb.reverse();
                sb.append(" ");
                str[a++] = sb.toString();
            }
            str[a+1] = "\n";
            a += 2;
        }
        for(String s : str){
            if(s != null) System.out.print(s);
        }


    }


}
