package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringAnaly_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str = br.readLine()) != null){
            int[] ans = new int[4];
            char[] arr = str.toCharArray();

            for(int i=0; i<arr.length; i++){
                char c = arr[i];
                if(c == ' '){ ans[3]++; }
                else if(c < 58){ ans[2]++; }
                else if(c < 91){ ans[1]++; }
                else if(c < 123){ ans[0]++; }
            }

            for(int i : ans){ System.out.print(i + " "); }
            System.out.println();
        }
    }
}
