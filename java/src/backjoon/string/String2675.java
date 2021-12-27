
package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        String str = "";

        int test = Integer.parseInt(st.nextToken());
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            str = st.nextToken();

            char[] ch = str.toCharArray();
            for(int j=0; j<ch.length; j++){
                for(int k=0; k<repeat; k++){
                    sb.append(ch[j]);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    /*
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] repeat = new int[1000];
        String[] str = new String[1000];
        char[][] ch = new char[test][20];

        for (int i = 0; i < test; i++) {
            repeat[i] = sc.nextInt();
            str[i] = sc.next();
            for (int j = 0; j < str[i].length(); j++) {
                ch[i][j] = str[i].charAt(j);
            }
        }
        for (int i = 0; i < ch.length; i++){
            for (int j = 0; j < str[i].length(); j++){
                for(int k=0; k<repeat[i]; k++){
                    System.out.print(ch[i][j]);
                }
            }
            System.out.println();
        }
     */

}
