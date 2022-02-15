package algoexam;

import java.util.Scanner;

public class Algo2_exam {
    static int[][] square;
    static boolean[][] visited;
    static int[] borderSum;
    static int sum;
    static int N;
    static int idx;
    static int lastidx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스
        for(int t=1; t<=T; t++){
            N = sc.nextInt(); // 사각형의 크기
            square = new int[N][N];
            visited = new boolean[N][N];
            lastidx = N/2;
            borderSum = new int[lastidx + 2]; // 사각형 테두리 개수
            idx = borderSum.length - 1;


            // 계산할 테두리 번호
            int firstBorder = sc.nextInt();
            int secBorder = sc.nextInt();

            // 사각형 값 채워넣기
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    square[i][j] = sc.nextInt();
                }
            }

            // 테두리 합계 계산, 변수 모두 초기화
            d = 0;
            sum = 0;
            sum += square[0][0];
            visited[0][0] = true;
            sy = 0;
            sx = 0;
            getBorderSum();

            int ans = Math.abs(borderSum[firstBorder] - borderSum[secBorder]);
            System.out.printf("#%d %d", t, ans);
        }
    }

    // 우 하 좌 상 순으로 검사
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int d;
    static int sy;
    static int sx;


    static void getBorderSum(){
        while (true){
            d = d % 4; // 방향 전환
            int newY = sy + dy[d];
            int newX = sx + dx[d];
            if(!checkWall(newY, newX) && !visited[newY][newX]){ // 벽이 아니고 방문하지도 않은 경우 체크
                visited[newY][newX] = true;
                sum += square[newY][newX];
                sy = newY;
                sx = newX;
            }
            else { // 벽을 만나거나 이미 방문한 경우 방향 전환
                if(d != 0 && d % 3 == 0){ // 위쪽으로 검사중이던 경우 한 테두리의 종료
                    borderSum[idx--] = sum; // 바깥 테두리부터 값 저장
                    sum = 0;
                }
                if(sy  == lastidx && sx == lastidx){ // 마지막 값인 경우
                    borderSum[1] = sum;
                    break;
                }
                d++;
            }

        }


    }
    static boolean checkWall(int ny, int nx){
        if(ny < 0 || nx < 0 || ny >= N || nx >=N) return true;
        return false;
    }


}
