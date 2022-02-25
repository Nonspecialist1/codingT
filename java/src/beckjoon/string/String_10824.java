
package beckjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        String AB = st.nextToken() + st.nextToken();
        String CD = st.nextToken() + st.nextToken();
        Long ans = Long.valueOf(AB) + Long.valueOf(CD);

        System.out.print(ans);
    }
}

