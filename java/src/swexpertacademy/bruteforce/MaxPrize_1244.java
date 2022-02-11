package swexpertacademy.bruteforce;

import java.util.Scanner;

public class MaxPrize_1244 {
    static String[] board;
    static int time;
    static int maxBoard;
    static String first;
    static int bin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        for(int T=1; T<=10; T++) {
            String str = String.valueOf(sc.nextInt());
            board = str.split("");

            int maxIdx = 0;
            for(int i=1; i<board.length; i++){
                if(Integer.valueOf(board[maxIdx]) <= Integer.valueOf(board[i])){ maxIdx = i;}
            }
            first = board[maxIdx];
            time = sc.nextInt(); // 반복 횟수

            maxBoard = 0;
            maxBoard = getMaxBoard(0, 0);
            if(maxBoard == 0){
                if(board.length == 1){ maxBoard = Integer.parseInt(board[0]); }
                else
                {
                    int minIdx = 0;
                    int secMin = 0;
                    for(int i=1; i<board.length; i++){
                        if(Integer.valueOf(board[minIdx]) >= Integer.valueOf(board[i])){ minIdx = i; }
                    }
                    for(int i=1; i<board.length; i++){
                        if(Integer.valueOf(board[secMin]) >= Integer.valueOf(board[i]) && (i != minIdx)){ secMin = i; }
                    }
                    while(time > 0){
                        swap(minIdx, secMin);
                        time--;
                    }
                }
                String sum = "";
                for(String s : board){ sum += s; }
                maxBoard = Integer.parseInt(sum);
            }

            System.out.println("#"+T+" "+maxBoard + "횟수 : " + bin);
        }
    }

    static int getMaxBoard(int idx, int cnt){
        bin++;

        if(cnt == time){
            String sum = "";
            for(String s : board){ sum += s; }
            if(Integer.valueOf(sum) > maxBoard){
                maxBoard = Integer.valueOf(sum);
            }
            return maxBoard;
        }

        for(int i=idx; i<board.length; i++){
            for(int j=i+1; j<board.length; j++)
            {
                if(Integer.valueOf(board[i]) <= Integer.valueOf(board[j]))
                {
                    if (i == 0) {
                        if (board[j].equals(first)) {
                            swap(i,j);
                            getMaxBoard(idx, cnt + 1);
                            swap(i,j);
                        }
                    }
                    else {
                        swap(i,j);
                        getMaxBoard(idx, cnt + 1);
                        swap(i,j);
                    }
                }
            }
        }
        return maxBoard;
    }

    static void swap(int lowIdx, int maxIdx){
        String temp = board[lowIdx];
        board[lowIdx] = board[maxIdx];
        board[maxIdx] = temp;
    }

}
