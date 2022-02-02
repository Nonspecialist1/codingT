package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class ladder_1210 {
    static int[][] arr = new int[100][100];
    // 벽을 만나는지 확인
    static  boolean check(int row, int col){
        if(row < 0 || row > 99) return false;
        if(col < 0 || col > 99) return false;
        if(arr[row][col] == 1) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            sc.nextInt();

            int col = 0;

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                    if(arr[i][j] == 2){ col = j; } // 열 번호 기억하기
                }
            }
            col = getStart(99, col); // 행, 열로 사다리 출발점 구하기
            System.out.printf("#%d %d\n", T, col);
        }
        sc.close();
    }

    public static int getStart(int row, int col){
        int d = 0; // -1 : 왼쪽, 0 : 위, 1 : 오른쪽
        // 출발점까지 반복
        while(row != 0){
            if((d == 0 || d == -1) && check(row, col-1)){ d = -1; col--; }
            else if((d == 0 || d == 1) && check(row, col+1)){ d = 1; col++; }
            else { d = 0; row--; }
        }
        return col;
    }


}
