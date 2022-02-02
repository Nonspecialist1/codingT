package swexpertacademy.array;

import java.io.IOException;
import java.util.Scanner;

public class mostValue_1204 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 테이스 case 개수
        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int caseNum = sc.nextInt();
            // 학생들의 점수 0점 ~ 100점
            int[] arr = new int[101];
            // 1000명의 학생들의 점수, 빈도를 ++
            for(int i=0; i<1000; i++){
                arr[sc.nextInt()]++;
            }
            int maxIdx = 0;
            // 최빈 점수 찾기
            for(int i=1; i<101; i++){
                if(arr[maxIdx] <= arr[i]){
                    maxIdx = i;
                }
            }
            System.out.printf("#%d %d\n", caseNum, maxIdx);
        }
        sc.close();
    }
}
