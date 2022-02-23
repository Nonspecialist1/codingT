package swexpertacademy.imlevel;

import java.util.Scanner;

public class SdocuExam_1974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        t:for(int T=1; T<=Tcase; T++){
            int[][] sdocu = new int[9][9];
            boolean[][] box = new boolean[9][10];

            int ans = 1;
            // 행체크, // 소박스 체크
            for(int i=0; i<9; i++){
                boolean[] rowVisit = new boolean[10];
                for(int j=0; j<9; j++){
                    sdocu[i][j] = sc.nextInt();
                    if(i < 3){
                        if(j < 3){
                            if(!box[0][sdocu[i][j]]){ box[0][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 6){
                            if(!box[1][sdocu[i][j]]){ box[1][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 9){
                            if(!box[2][sdocu[i][j]]){ box[2][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                    }
                    else if(i < 6){
                        if(j < 3){
                            if(!box[3][sdocu[i][j]]){ box[3][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 6){
                            if(!box[4][sdocu[i][j]]){ box[4][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 9){
                            if(!box[5][sdocu[i][j]]){ box[5][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                    }
                    else if(i < 9){
                        if(j < 3){
                            if(!box[6][sdocu[i][j]]){ box[6][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 6){
                            if(!box[7][sdocu[i][j]]){ box[7][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                        else if(j < 9){
                            if(!box[8][sdocu[i][j]]){ box[8][sdocu[i][j]] = true; }
                            else{ ans = 0;}
                        }
                    }

                    if(!rowVisit[sdocu[i][j]]){ rowVisit[sdocu[i][j]] = true; }
                    else{ ans =0; }
                }
            }
            // 열체크
            for(int i=0; i<9; i++){
                boolean[] colVisit = new boolean[10];
                for(int j=0; j<9; j++){
                    if(!colVisit[sdocu[j][i]]){ colVisit[sdocu[j][i]] = true; }
                    else{ System.out.println("#" + T + " " + 0); continue t; }
                }
            }

            System.out.printf("#%d %d\n", T, ans);
        }
    }

}
