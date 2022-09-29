package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasStation_13305 {

    private static int N, D_rest;
    private static long Total = 0;
    private static int[] Distance, Gas_fee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Distance = new int[N-1];
        Gas_fee = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            Distance[i] = Integer.parseInt(st.nextToken());
            D_rest += Distance[i];
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            Gas_fee[i] = Integer.parseInt(st.nextToken());
        }

        findMinGasFee();
        System.out.println(Total);
    }

    private static void findMinGasFee(){
        int minIdx = 0;
        int minFee = Gas_fee[0];

        for(int i=1; i<N-1; i++){
            int gas = Gas_fee[i];

            if(gas < minFee){ // 더 저렴한 주유소를 찾으면 거기까지 거리를 주유해가기
                fillUpGas(minIdx, i, minFee);

                minFee = gas;
                minIdx = i;
            }
        }

        // 아직 거리가 남았으면
        if(D_rest != 0){
            fillUpGas(minIdx, N-1, minFee);
        }
    }

    private static void fillUpGas(int st, int end, int fee){
        long distance = 0;
        for(int i=st; i<end; i++){
            distance += Distance[i];
        }

        Total += fee * distance;
        D_rest -= distance;
    }

}
