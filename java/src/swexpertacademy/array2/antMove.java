package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class antMove {
    static int[][] arr;
    static int cnt;
    // 벽을 만나는지 확인
    static int check(int col, int row){
        if(arr[col][row] == 2){ return 2; }
        else if(arr[col][row] == 1){ return 1; }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int size = sc.nextInt();
            arr = new int[size][size];

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            cnt = 0;
            getEnd(0, 0); // 행, 열로 사다리 출발점 구하기
            System.out.printf("#%d %d\n", T, cnt);
        }
        sc.close();
    }

    static int[] dy = {0, 1 , 0, -1};
    static int[] dx = {1, 0 , -1, 0};

    public static void getEnd(int col, int row){
        int d = 0; // 0: 오른쪽  1: 아래  2: 왼쪽  3: 위
        // 출발점까지 반복
        while(true){
            col += dy[d];
            row += dx[d];
            if(col == -1 || row == -1 || col == 10 || row == 10){ break; }
            cnt++;
            if(d == 0){ // 오른쪽으로 가던 중
                if(check(col, row) == 1){ d = 3;}
                else if(check(col, row) == 2){ d = 1;}
            }
            else if(d == 1){ // 아래로 가던 중
                if(check(col, row) == 1){ d = 2;}
                else if(check(col, row) == 2){ d = 0;}
            }
            else if(d == 2){ // 왼쪽으로 가던 중
                if(check(col, row) == 1){ d = 1;}
                else if(check(col, row) == 2){ d = 3;}
            }
            else if(d == 3) { //위로 가던 중
                if(check(col, row) == 1){ d = 0;}
                else if(check(col, row) == 2){ d = 2;}
            }
        }
    }


}
