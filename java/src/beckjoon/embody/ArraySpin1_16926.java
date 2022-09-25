package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArraySpin1_16926 {

    static int N, M, R;
    static int[][] Arr;
    static int[][] NewArr;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Arr = new int[N][M]; // 원배열

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<R; i++){ // R번 만큼 반시계 회전
            NewArr = new int[N][M]; // 새배열
            Visit = new boolean[N][M]; // 원배열 방문
            AntiClockDir();
            Arr = NewArr;
        }

        printArr();
    }

    private static void printArr(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<NewArr.length; i++){
            for(int j=0; j<NewArr[0].length; j++){
                sb.append(NewArr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void AntiClockDir(){ // 테두리 부터 안쪽으로 반시계 방향
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!Visit[j][i]){ // 이동 안 했으면
                    NewArr[j+1][i] = Arr[j][i];
                    Visit[j][i] = true;
                }
            }
        }

    }

}