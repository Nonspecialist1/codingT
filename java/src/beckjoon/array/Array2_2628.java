package beckjoon.array;

import java.util.Scanner;

public class Array2_2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[col][row];

        int T = sc.nextInt(); // 자르는 횟수
        int max = 0;
        int cnt = 0;
        while(T != 0){
            cnt = 1;
            int dir = sc.nextInt(); // 자르는 방향
            int idx = sc.nextInt(); // 자르는 번호
            if(dir == 0){ // 가로로 자름 (col 에서 끊기)
               for(int i=0; i<idx; i++){
                   for(int j=0; j<arr.length; j++){
                       if(arr[i][j] != 0){ arr[i][j] = cnt + 1; }
                       else{ arr[i][j] = cnt; }
                   }
               }
               cnt++;
            }
            else { // 세로로 자름 (row 에서 끊기)
                for(int i=0; i<col; i++){
                    for(int j=0; j<idx; j++){
                        if(arr[i][j] != 0){ arr[i][j] = cnt + 1; }
                        else{ arr[i][j] = cnt; }
                    }
                }
                cnt++;
            }
            T--;
        }
        int zero = 0;
        int fir = 0;
        int sec = 0;
        int third = 0;
        int forth = 0;
        int fif = 0;
        int six = 0;
        for(int i=0; i<col; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] == 0){ zero++; }
                if(arr[i][j] == 1){ fir++; }
                if(arr[i][j] == 2){ sec++; }
                if(arr[i][j] == 3){ third++; }
                if(arr[i][j] == 4){ forth++; }
                if(arr[i][j] == 5){ fif++; }
                if(arr[i][j] == cnt){ six++; }
            }
        }
        int oneMax = Math.max(zero, fir);
        int twoMax = Math.max(sec, third);
        int thrMax = Math.max(forth, fif);
        int oneTwoMax = Math.max(oneMax, twoMax);
        int thirForMax = Math.max(thrMax, six);
        max = Math.max(oneTwoMax, thirForMax);
        System.out.println(max);
    }
}
