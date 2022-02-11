package beckjoon.imlevel;

import java.util.Scanner;

public class roomCnt_13300 {
    static int[][] person = new int[2][7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int maxNum = sc.nextInt();
        int room = 0;

        for(int i=0; i<N; i++){
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            person[gender][grade]++;
        }

        for(int i=0; i<2; i++){
            for(int j=1; j<7; j++){
                if(person[i][j] != 0){
                    room += Math.ceil((double)person[i][j] / maxNum);
                }
            }
        }
        System.out.println(room);
    }
}
