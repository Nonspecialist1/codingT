package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class ladder_1210 {
    static int[][] arr;
    static boolean ladder = false;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int tCase = sc.nextInt();
            arr = new int[100][100];
            int col = 0;

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j] == 2){ col = j; } // 열 번호 기억하기
                }
            }
            col = getStart(99, col); // 행, 열로 사다리 출발점 구하기
            System.out.printf("#%d %d\n", tCase, col);
        }
    }

    static int[] dx = {-1, 1};
    public static int getStart(int row, int col){
        // 출발점까지 반복
        while(true){
            //위로 탐색
            row--;
            // 출발점 찾으면 끝
            if(row == 0) { break; }
            ladder = false;
            // 좌우 사다리 탐색
            for(int d =0; d<2; d++){
                int newCol = col + dx[d]; // 열 좌우로 이동
                if(newCol < 0 || newCol > 99){ continue; } // 벽을 만나는 경우
                if(arr[row][newCol] == 1){ // 사다리 있는 경우
                    ladder = true;
                    col = newCol; // 사다리로 열 이동
                    while(true){
                        newCol = col + dx[d]; // 좌우 방향 고정
                        if(newCol < 0 || newCol > 99 || arr[row][newCol] == 0){ break; }
                        else { col = newCol; }
                    }
                }
                if(ladder){ break; }
            }
        }
        return col;
    }
}
