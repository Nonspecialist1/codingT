package beckjoon.array;

import java.util.Scanner;

public class Array_2_2269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] arr = new boolean[101][101];
        int test = 0;
        int cnt = 0;
        // 도형 채워넣기
        while (test != 4) {
            int leftX = sc.nextInt();
            int leftY = sc.nextInt();
            int rightX = sc.nextInt();
            int rightY = sc.nextInt();
            for (int i=leftX; i<rightX; i++) {
                for (int j=leftY; j<rightY; j++) {
                    arr[i][j] = true;
                }
            }
            test++;
        }
        // 채워진 값 구하기
        for (int i = 0; i<101; i++) {
            for (int j = 0; j<101; j++) {
                if(arr[i][j] == true){ cnt++; }
            }
        }
        System.out.println(cnt);
    }

}
