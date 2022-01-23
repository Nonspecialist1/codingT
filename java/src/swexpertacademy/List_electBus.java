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
            st = new StringTokenizer(br.readLine());
            int[] chargePoint = new int[charger];
            for(int j=0; j<charger; j++){
                chargePoint[j] = Integer.parseInt(st.nextToken());
            }
            int currentPosition = 0;
            int cnt = 0;
            int cp = 0;
            while(currentPosition < lastPoint) {
                currentPosition += maxMove;
                if (currentPosition >= lastPoint) {
                    break;
                }
                if(chargePoint[cp] > currentPosition){
                    cnt = 0;
                    break;
                }
                int maxPoint = 0;
                while(chargePoint[cp] <= currentPosition) {
                    maxPoint = chargePoint[cp];
                    if(cp+1 < charger) {
                        cp++;
                    } else {
                        break;
                    }
                }
                currentPosition = maxPoint;
                cnt++;
            }
            System.out.printf("#%d %d\n", i+1, cnt);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
