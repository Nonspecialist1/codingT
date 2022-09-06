package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArraySpin3_16935 {

    static int N, M, R;
    static int[][] Arr;
    static int[][] NewArr;

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

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            int num = Integer.parseInt(st.nextToken());
            int n = Arr.length;
            int m = Arr[0].length;

            NewArr = new int[n][m]; // 새배열
            switch (num){
                case 1 : calOne(n, m);
                    break;
                case 2 : calTwo(n, m);
                    break;
                case 3 : NewArr = new int[m][n]; // 새배열
                    calThree(n, m);
                    break;
                case 4 : NewArr = new int[m][n]; // 새배열
                    calFour(n, m);
                    break;
                case 5 : calFive(n, m);
                    break;
                case 6 : calSix(n, m);
                    break;
                default : break;
            }
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

    private static void calOne(int n, int m){ // 1번 상하반전 6,0 -> 0,0 / 6,1 -> 0,1 ----- 6,8 -> 0,8
        for(int i=n-1, a=0; i>=0; i--, a++){
            for(int j=0, b=0; j<m; j++, b++){
                NewArr[a][b] = Arr[i][j];
            }
        }
    }

    private static void calTwo(int n, int m){ // 2번 좌우반전 0,M -> 0,0 / 1,M -> 1,0
        for(int i=0, a=0; i<n; i++, a++){
            for(int j=m-1, b=0; j>=0; j--, b++){
                NewArr[a][b] = Arr[i][j];
            }
        }
    }

    private static void calThree(int n, int m){ // 3번 오른쪽으로 90도 회전 - N,0 -> 0,0 / N,1 -> 0,1 ------- N,M -> 0,M
        for(int i=0, a=0; i<m; i++, a++){
            for(int j=n-1, b=0; j>=0; j--, b++){
                NewArr[a][b] = Arr[j][i];
            }
        }
    }

    private static void calFour(int n, int m){ // 4번 왼쪽으로 90도 회전
        for(int i=m-1, a=0; i>=0; i--, a++){
            for(int j=0, b=0; j<n; j++, b++){
                NewArr[a][b] = Arr[j][i];
            }
        }
    }


    private static void calFive(int n, int m){
        int newN = Arr.length / 2;
        int newM = Arr[0].length / 2;

        for(int i=0; i<newN; i++) { // 1을 2로 옮긴 것
            for(int j=0, a=newM; j<newM; j++, a++) {
                NewArr[i][a] = Arr[i][j];
            }
        }

        for(int i=0, a=newN; i<newN; i++, a++) { // 2를 3로 옮긴 것
            for(int j=newM; j<m; j++) {
                NewArr[a][j] = Arr[i][j];
            }
        }

        for(int i=newN; i<n; i++) { // 3을 4로 옮긴 것
            for(int j=newM, a=0; j<m; j++, a++) {
                NewArr[i][a] = Arr[i][j];
            }
        }

        for(int i=newN, a=0; i<n; i++, a++) { // 4를 1로 옮긴 것
            for(int j=0; j<newM; j++) {
                NewArr[a][j] = Arr[i][j];
            }
        }
    }

    private static void calSix(int n, int m){
        int newN = Arr.length / 2;
        int newM = Arr[0].length / 2;

        for(int i=0, a=newN; i<newN; i++, a++) { // 1을 4로 옮긴 것
            for(int j=0; j<newM; j++) {
                NewArr[a][j] = Arr[i][j];
            }
        }

        for(int i=newN; i<n; i++) { // 4를 3로 옮긴 것
            for(int j=0, a=newM; j<newM; j++, a++) {
                NewArr[i][a] = Arr[i][j];
            }
        }

        for(int i=newN, a=0; i<n; i++, a++) { // 3을 2로 옮긴 것
            for(int j=newM; j<m; j++) {
                NewArr[a][j] = Arr[i][j];
            }
        }

        for(int i=0; i<newN; i++) { // 2를 1로 옮긴 것
            for(int j=newM, a=0; j<m; j++, a++) {
                NewArr[i][a] = Arr[i][j];
            }
        }
    }

}