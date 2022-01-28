package swexpertacademy.string;

import java.util.Scanner;

public class panlindrome_1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int T=1; T<=10; T++){
            // 회문의 수
            int cnt = 0;
            // 회문의 길이
            int length =  sc.nextInt();
            // 문자를 저장할 배열
            char[][] arr = new char[8][8];
            // 문자 입력받기 8x8
            for(int i=0; i<8; i++){
                String str = sc.next();
                for(int j=0; j<8; j++){
                    arr[i][j] = str.charAt(j);
                }
            }
            // 배열 가로 확인
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-length; j++){
                    String str = "";
                    for(int k=j; k<length+j; k++){  // < 6
                        str += arr[i][k];
                    }
                    String str2 = new StringBuilder(str).reverse().toString();
                    if(str.equals(str2)){ cnt++; }
                }
            }
            // 배열 세로 확인
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-length; j++){
                    String str = "";
                    for(int k=j; k<length+j; k++){
                        str += arr[k][i];
                    }
                    String str2 = new StringBuilder(str).reverse().toString();
                    if(str.equals(str2)){ cnt++; }
                }
            }
            System.out.printf("#%d %d\n", T, cnt);
        }
    }
}
