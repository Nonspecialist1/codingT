package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class sum_1209 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int caseNum = sc.nextInt();

            int[][] arr = new int[100][100];
            int max = 0;
            int rightMax = 0;
            int leftMax = 0;

            for(int i=0; i<100; i++){
                int rowMax = 0; // 행의 합계, i증가마다 초기화
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                    rowMax += arr[i][j];
                }
                rightMax += arr[i][i]; //오른쪽 대각선의 합계
                leftMax += arr[i][99 - i]; //왼쪽 대각선의 합계
                if(rowMax > max){ max = rowMax; }  // 행의 합계 최댓값
            }
            for(int i=0; i<100; i++) {
                int columnMax = 0; // 열의 합계, i증가 마다 초기화
                for (int j = 0; j < 100; j++) {
                    columnMax += arr[j][i];
                } // 행의 최댓값과 열의 최댓값 비교
                if(columnMax > max){ max = columnMax; }
            }
            int crossMax = Math.max(rightMax, leftMax);
            if(crossMax > max){ max = crossMax; }

            System.out.printf("#%d %d\n", caseNum, max);
        }
        sc.close();
    }
}
