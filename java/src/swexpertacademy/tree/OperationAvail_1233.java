package swexpertacademy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperationAvail_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            int N = Integer.parseInt(br.readLine()) + 1;
            int ans = 1;

            for (int i=1; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 정점번호 버리기
                String val = st.nextToken(); // 정점에 해당하는 값 유효성 검사
                if(val.equals("*") || val.equals("/") || val.equals("-") || val.equals("+"))
                {
                    if(!st.hasMoreTokens()) ans = 0;
                    else {
                        st.nextToken();
                        if(!st.hasMoreTokens()) ans = 0;
                    }
                }
                else { if(st.hasMoreTokens()) ans = 0; }
            }
            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
