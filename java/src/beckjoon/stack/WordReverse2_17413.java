package beckjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordReverse2_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ans = new char[str.length()];
        StringBuilder sb;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '<'){
                while(str.charAt(i) != '>'){
                    ans[i] = str.charAt(i);
                    i++;
                }
                ans[i] = str.charAt(i);
            }
            else if(str.charAt(i) == ' '){
                ans[i] = ' ';
            }
            else {
                sb = new StringBuilder();
                int j = i; // 7
                while(i < str.length() && str.charAt(i) != '<' && str.charAt(i) != ' '){
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.reverse();
                for(int k=0; k<sb.length(); k++){
                    ans[j++] = sb.charAt(k);
                }
                i--;
            }
        }

        for(char c : ans){
            System.out.printf("%c", c);
        }


    }
}
