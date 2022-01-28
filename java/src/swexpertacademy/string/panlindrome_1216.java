package swexpertacademy.string;

import java.util.Scanner;

public class panlindrome_1216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int T=1; T<=10; T++){
            // 테스트케이스
            int tCase =  sc.nextInt();
            // 회문의 최대 길이
            int maxLen = 0;
            // 문자를 저장할 배열
            char[][] arr = new char[100][100];
            // 문자 입력받기 100x100
            for(int i=0; i<100; i++){
                String str = sc.next();
                for(int j=0; j<100; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            // 이진 검색, 최대길이 구하기
            boolean check = false;
            int len = 100;

            while(len > 1 && !check){
                // 시작 점
                int start = 0;
                int end = 100-len;

                for(int i=0; i<100; i++){
                    for(int j=start; j<=end; j++){
                        // 가로 검색
                        for(int r=0; r< len/2; r++){
                            if(arr[i][j+r] != arr[i][j+len-1-r]){
                                break;
                            }
                            else{
                                if(r == len/2 -1){
                                    maxLen = len;
                                    check = true;
                                    break;
                                }
                            }
                        }
                        // 세로 검색
                        for(int r=0; r< len/2; r++){
                            if(arr[j+r][i] != arr[j+len-1-r][i]){
                                break;
                            }
                            else{
                                if(r == len/2 -1){
                                    maxLen = len;
                                    check = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(check){ break; }
                }
                len--;
            }
            System.out.printf("#%d %d\n", tCase, maxLen);
        }
    }
}
