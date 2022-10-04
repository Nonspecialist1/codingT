package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rain_14719 {

    static int H, W;
    static int[] Block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        Block = new int[W];
        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i=0; i<W; i++){
            Block[i] = Integer.parseInt(st.nextToken());
            if(Block[i] > 0) cnt++;
        }

        if(cnt < 2){ // 성능 최적화
            System.out.println(0);
            return;
        }

        System.out.println(solve());
    }

    private static int solve(){
        int total = 0;

        for(int i=1; i<=H; i++){
            int preIdx = -1;
            boolean hasSpace = false;

            // 맨 밑에서부터 위로가며 오른쪽 끝까지 탐색
            for(int j=0; j<W; j++){
                if(Block[j] >= i){ // 해당 높이에 블록이 있는 경우
                    if(hasSpace){ // 사이에 블록이 있는 경우
                        total += j - preIdx - 1;
                        hasSpace = false;
                    }

                    preIdx = j;
                }
                else if(preIdx >= 0){
                    hasSpace = true;
                }
            }
        }

        return total;
    }
}
