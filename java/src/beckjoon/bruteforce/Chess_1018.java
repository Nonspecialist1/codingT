package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess_1018 {
    static int N;
    static int M;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        char color = 'W';
        for(int y=0; y<=N-8; y++){
            for(int x=0; x<=M-8; x++){
                boolean start = true;
                int cnt = 0;

                for(int i=y; i<y+8; i++){
                    if(color == 'B') color = 'W';
                    else color = 'B';

                    for(int j=x; j<x+8; j++){
                        if(start){
                            if(board[i][j] == 'W'){ color = 'B'; }
                            else { color = 'W'; }
                            start = false;
                        }
                        else {
                            if(board[i][j] != color){ cnt++; }
                            if(color == 'B') color = 'W';
                            else color = 'B';
                        }
                    }
                }

                cnt = Math.min(cnt, 64-cnt);
                if(cnt < ans) ans = cnt;
            }
        }

        System.out.println(ans);
    }
}
