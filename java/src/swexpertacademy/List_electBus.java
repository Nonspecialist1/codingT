package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class List_electBus {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int maxMove = Integer.parseInt(st.nextToken());
            int lastPoint = Integer.parseInt(st.nextToken());
            int charger = Integer.parseInt(st.nextToken());




        }
    }
}
