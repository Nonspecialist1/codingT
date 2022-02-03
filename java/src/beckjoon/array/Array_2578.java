package beckjoon.array;

import java.util.Scanner;

public class Array_2578 {
    static int[][] arr = new int[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int iCnt = 0;
        while(true){
            int idx = sc.nextInt();
            a:for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(arr[i][j] == idx){ arr[i][j] = 0; break a; }
                }
            }
            iCnt++;
            if(checkBingo()){ break; }
        }
        System.out.println();
        System.out.println(iCnt);
    }

    static int cnt;
    static boolean flag = false;

    static boolean checkBingo(){
        cnt = 0;
        // 행 검사
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[i][j] != 0){
                    flag = false;
                    break;
                }
                else { flag = true; }
            }
            if(flag){ cnt++; }
        }

        // 열 검사
        flag = false;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] != 0){
                    flag = false;
                    break;
                }
                else { flag = true; }
            }
            if(flag){ cnt++; }
        }

        // 오른쪽 아래 대각선 검사
        flag = false;
        for(int i=0; i<5; i++){
            if(arr[i][i] != 0){
                flag = false; break;
            }
            else { flag = true; }
        }
        if(flag){ cnt++; }

        // 왼쪽 아래 대각선 검사
        flag = false;
        for(int i=0, j=4; i<5; i++, j--){
            if(arr[i][j] != 0){
                flag = false;
                break;
            }
            else { flag = true; }
        }
        if(flag){ cnt++; }

        if(cnt >= 3){ return true; }
        return false;
    }

}
