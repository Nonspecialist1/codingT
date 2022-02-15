package algoexam;

import java.util.Scanner;

public class Algo3_exam {
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스
        for(int t=1; t<=T; t++){
            int N = sc.nextInt(); // 사각형의 크기
            String[] str = new String[N];
            visited = new boolean[10];

            for(int i=0; i<N; i++){ // 문자열로 받기
                str[i] = String.valueOf(sc.nextInt());
            }
            // 1 ~ 9 까지 검사
            for(int i=0; i<N; i++){ // 문자열로 받기
                for(int j=0; j<3; j++){
                    char c = str[i].charAt(j);
                    int idx = Integer.parseInt(String.valueOf(c));
                    if(!visited[idx]) visited[idx] = true; // 1~9 인지 체크
                }
            }

            int ans = 1;
            for(int i=1; i<10; i++){ // 1 ~ 9 중 하나라도 체크가 안되어 있으면 0
                if(!visited[i]) ans = 0;
            }
            System.out.printf("#%d %d", t, ans);
        }
    }

}
