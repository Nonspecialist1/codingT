
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] suffix = new String[ str.length() ];

        for(int i=0; i<str.length(); i++){
            suffix[i] = str.substring(i, str.length());
        }
        Arrays.sort(suffix);

        for(String s : suffix){ sb.append(s + "\n"); }
        System.out.print(sb);
    }
}

