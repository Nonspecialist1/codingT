package algoexam.ssafy;

import java.util.*;

interface Opponent {
   int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]);
}

public class HuntingDeer {
    
    private static int DEER = 0;
    private static int RABBIT = 1;
    private static int SNAKE = 2;
    private static int gumi6_5_snake_cnt = 0;

    // 경원님
    private static int Gumi6_5_count = 0;
    // 용준이
    private static boolean gumi6_5_betrayer = false;
    private static int gumi6_5_prev = -1;
    private static int gumi6_5_cnt = 0;

    private static int gwangju4_2_num = 2; // 선택할 동물
    private static int gwangju4_2_cnt = 0; // 상대방이 뱀을 낸 누적 횟수


    static Opponent Me = new Opponent() { 
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
			int result = DEER;
            System.out.printf("현재 턴 : %d  / 상대의 이전 선택 : %d\n", turn, opp_prev);

            int exist_deer = 0;
            if(opp_prev == -1){ // 첫번째 판의 경우
                gumi6_5_snake_cnt = 0; // 초기화
                System.out.printf("상대가 이전에 진행한 게임들의 첫 번째 선택 : ");
                for(int i=0; i<10; i++){
                    System.out.printf(" %d ", opp_last_pattern[i][0]);
                    if(opp_last_pattern[i][0] == DEER){
                        exist_deer++; // 첫번째로 사슴을 잡는 횟수
                    }
                }
                System.out.printf("\n");
            }
            // 첫번째로 사슴을 잡는 경우가 희박할 때 뱀으로 감
            if(exist_deer < 2){ result = SNAKE; }

            if(opp_prev == DEER){ result = DEER; }
            else if(opp_prev == RABBIT){ result = SNAKE; }
            else if(opp_prev == SNAKE){
                result = SNAKE;
            }

            if(result == SNAKE){
                gumi6_5_snake_cnt++;
                // 내가 패널티를 받는 경우 사슴내기
                if(gumi6_5_snake_cnt > 5){
                    result = DEER;
                    gumi6_5_snake_cnt = 0;
                }
            }

			return result;
        }
    };

    static Opponent ran = new Opponent() {
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            return new Random().nextInt(3);
        }
    };

    static Opponent sangwook = new Opponent() {
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {

            if(opp_last_pattern[0][0] == -1) {

                switch(turn) {
                    case 0 :
                    case 1 :
                        return SNAKE;
                    case 2 :
                    case 3 :
                        return RABBIT;
                    case 4 :
                    case 5 :
                        return SNAKE;
                    case 6 :
                    case 7 :
                        return RABBIT;
                    case 8 :
                    case 9 :
                        return SNAKE;
                }
            }


            if(opp_last_pattern[0][0] != -1) {

                if(opp_prev == -1) {
                    int oppNum = opp_last_pattern[0][turn];

                    switch(oppNum) {
                        case 0: return DEER;
                        case 1: return SNAKE;
                        case 2: return SNAKE;
                    }
                }else {

                    if(opp_prev == opp_last_pattern[0][turn]) {
                        int oppNum = opp_last_pattern[0][turn];

                        switch(oppNum) {
                            case 0: return DEER;
                            case 1: return SNAKE;
                            case 2: return SNAKE;
                        }
                    }else {

                        return SNAKE;

                    }

                }


            }

            return 1;
        }
    };
    
    static Opponent youngjun = new Opponent() {
        /**
         * opp : 상대방 플레이어 번호 turn : 0 ~ 9 해당 플레이어와의 현재 진행 턴 opp_prev : 이번 게임에서 현재 상대방의
         * 바로 이전 선택 opp_last_pattern[][10] : 현재 상대 방의 바로 이전 게임 기록 -1 : 모름 0 : 사슴 1 : 토끼
         * 2 : 뱀
         */
        public void gumi6_5_set_prev(int num) {
            if (gumi6_5_prev == num) {
                gumi6_5_cnt++;
            } else {
                gumi6_5_prev = num;
                gumi6_5_cnt = 0;
            }
        }

        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            Random random = new Random();

            int result = RABBIT;

            // 상대방의 이전 게임 파악
            int[] opp_last_cnt = new int[4];
            for (int i = 0; i < 10; i++) {
                int opp_select = opp_last_pattern[0][i];
                switch (opp_select) {
                    case 0:
                    case 1:
                    case 2:
                        opp_last_cnt[opp_select]++;
                        break;
                    default:
                        opp_last_cnt[3]++;
                        break;
                }
            }

            if (opp_last_cnt[1] == 5 && opp_last_cnt[2] == 5) {
                // 내가 3회 연속 됐다면 다른 패로 바꾼다.
                if (gumi6_5_cnt > 2) {
                    if (gumi6_5_prev == 0 || gumi6_5_prev == 1) {
                        gumi6_5_prev = 2;
                        result = SNAKE;
                    } else {
                        gumi6_5_prev = 0;
                        result = DEER;
                    }
                } else {
                    result = SNAKE;
                    gumi6_5_set_prev(result);
                    // 직전에 뱀을 낸 사람이라면 토끼를 낼 것이다.
                }
            }
            else if (opp_last_cnt[1] == 5 && opp_last_cnt[2] == 5)
            {
                if (gumi6_5_cnt > 2) {
                    if (gumi6_5_prev == 0 || gumi6_5_prev == 1) {
                        gumi6_5_prev = 2;
                        result = RABBIT;
                    } else {
                        gumi6_5_prev = 0;
                        result = DEER;
                    }
                } else{
                    result = random.nextInt(1);
                    if(result == 1) {
                        result = SNAKE;
                    }
                    gumi6_5_set_prev(result);
                }
            }
            // 사슴과 토끼을 반반 내는 사람
            else if (opp_last_cnt[1] == 5 && opp_last_cnt[2] == 5)
            {
                if (gumi6_5_cnt > 2) {
                    if (gumi6_5_prev == 0 || gumi6_5_prev == 1) {
                        gumi6_5_prev = 2;
                        result = SNAKE;
                    } else {
                        gumi6_5_prev = 0;
                        result = DEER;
                    }
                } else if(opp_prev == 2) {
                    result = DEER;
                    gumi6_5_set_prev(result);
                } else {
                    result = SNAKE;
                    gumi6_5_set_prev(result);
                }
            }

            // 이전 기록이 없을 때
            else if (opp_last_cnt[3] == 10) {
                // 상대가 배신자인 경우
                if (gumi6_5_betrayer) {
                    // 토끼와 뱀을 번갈아 낸다.
                    result = random.nextInt(1) + 1;
                } else {
                    // 첫번 째 게임일 경우
                    if (opp_prev == -1) {
                        result = DEER;
                    } else if (opp_prev == 0) {
                        result = DEER;
                    } else if (opp_prev == 1) {
                        result = random.nextInt(1) + 1;
                    } else {
                        gumi6_5_betrayer = true;
                        result = SNAKE;
                    }
                }
                // 사슴을 많이 내는 사람이면
            } else if (opp_last_cnt[0] > 8) {
                if (gumi6_5_cnt > 2) {
                    if (gumi6_5_prev == 0 || gumi6_5_prev == 1) {
                        gumi6_5_prev = 2;
                        result = RABBIT;
                    } else {
                        gumi6_5_prev = 0;
                        result = DEER;
                    }
                } else{
                    result = random.nextInt(1);
                    gumi6_5_set_prev(result);
                }
            } else
            // 모르겠다 랜덤 ㄱㄱ
            {
                return random.nextInt(2);
            }

            return result; // 반드시 0 또는 1 또는 2로 리턴해야합니다.
        }
    };
    
    static Opponent kungwon = new Opponent() {
        public int hunt(int opp, int turn, int opp_prev, int opp_last_pattern[][]) {
            int[] a_list = { DEER, RABBIT, SNAKE };
            int out = 0;
            Random rand = new Random();

            // 시작 전 이전 패턴 살펴보기
            int deerCnt = 0;
            int rabbitCnt = 0;
            int snakeCnt = 0;
            int firstCnt = 0;

            for (int i = 0; i < 10; i++) {
                if (opp_last_pattern[0][i] == -1) {
                    firstCnt++;
                }
                if (opp_last_pattern[0][i] == 0) {
                    deerCnt++;
                }
                if (opp_last_pattern[0][i] == 1) {
                    rabbitCnt++;
                }
                if (opp_last_pattern[0][i] == 2) {
                    snakeCnt++;
                }
            }

            // 첫판이면
            if (firstCnt >= 2) {
                // 랜덤으로 돌리기
                out = a_list[(int) (Math.random() * 3)];
                return out;
            }

            // 패턴 분석
            int[] candidate = new int[10];
            for (int i = 0; i < deerCnt; i++) {
                candidate[i] = DEER;
            }
            for (int i = deerCnt; i < deerCnt + rabbitCnt; i++) {
                candidate[i] = RABBIT;
            }
            for (int i = deerCnt + rabbitCnt; i < 10; i++) {
                candidate[i] = SNAKE;
            }

            // 배열 내부 값대로 출력
            out = candidate[rand.nextInt(10)];

            return out; // 반드시 0 또는 1 또는 2로 리턴해야합니다.
        }
    };
    
    private static Opponent[] f = new Opponent[100];
    private static String[] names = new String[100];
    private static int f_inx = 0;
    
    static void Register (String name, Opponent func)
    {
        names[f_inx] = name;
        f[f_inx++] = func;
    }
    
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        
        int[] total_score = new int[150];
        int[][][] last_pattern = new int[150][150][10];
        int[] pattern_count = new int[150];
        
		Register("Me", Me);
		Register("Opp1", ran);
		Register("youngjun", youngjun);
		Register("kungwon", kungwon);
        Register("sangwook", sangwook);
        
        for(int i=0; i<140; i++)
            for(int j=0; j<140; j++)
                for(int k=0; k<10; k++)
                    last_pattern[i][j][k] = -1;
                    
        for(int i=1; i<f_inx; i++) {
            for(int j=0; j<f_inx; j++){
                
                int team_a = j % f_inx;
                int team_b = (j + i) % f_inx;
                
                System.out.println(String.format("[%s] vs [%s]", names[team_a], names[team_b])); 
                
                int a_game_score = 0;
                int b_game_score = 0;
                
                int prev_a = -1;
                int prev_b = -1;
                
                int team_a_count = 0;
                int team_b_count = 0;
                
                int[] a_pattern = new int[10];
                int[] b_pattern = new int[10]; 
                
                for(int k=0; k<10; k++){
                
                    int a = f[team_a].hunt(team_b, k, prev_b, last_pattern[team_b]);
                    int b = f[team_b].hunt(team_a, k, prev_a, last_pattern[team_a]);
                    
                    a_pattern[k] = a;
                    b_pattern[k] = b;
                    
                    if(a == prev_a) team_a_count += a+1; else team_a_count = 0;
                    if(b == prev_b) team_b_count += b+1; else team_b_count = 0;
                
                    if(a != 0 && a != 1 && a != 2) team_a_count = 100;
                    if(b != 0 && b != 1 && b != 2) team_b_count = 100;
                    
                    prev_a = a;
                    prev_b = b;
                    
                    int a_score = 0;
                    int b_score = 0;
                    int a_bonus = 0;
                    int b_bonus = 0;
                    
                    if(a == DEER && b == DEER) {a_score = 50; b_score = 50;}
                    else if(a == DEER && b == RABBIT) {a_score = 0; b_score = 20;}
                    else if(a == DEER && b == SNAKE) {a_score = 0; b_score = 10;}
                    else if(a == RABBIT && b == DEER) {a_score = 20; b_score = 0;}
                    else if(a == RABBIT && b == RABBIT) {a_score = 20; b_score = 20;}
                    else if(a == RABBIT && b == SNAKE) {a_score = 0; b_score = 30;}
                    else if(a == SNAKE && b == DEER) {a_score = 10; b_score = 0;}
                    else if(a == SNAKE && b == RABBIT) {a_score = 30; b_score = 0;}
                    else if(a == SNAKE && b == SNAKE) {a_score = 10; b_score = 10;}
                    
                    a_score -= team_a_count;
                    b_score -= team_b_count;
                    
                    a_bonus = random.nextInt(3);
                    b_bonus = random.nextInt(3);
                    a_score += a_bonus;
                    b_score += b_bonus;
                    
                    a_game_score += a_score;
                    b_game_score += b_score;
                    
                    System.out.println(String.format("Turn [%d] [%s:(%s)] vs [%s:(%s)] ---> score [%d] / [%d] ", 
                        k+1, names[team_a], (a!=0) ? (a==2 ? "SNAKE" : "RABBIT") : "DEER",
					    names[team_b], (b!=0) ? (b == 2 ? "SNAKE" : "RABBIT") : "DEER", a_game_score, b_game_score));
                    
                }

                for (int z = 0; z<10; z++) { 
                    last_pattern[team_a][pattern_count[team_a]][z] = a_pattern[z];
                }
                for (int z = 0; z<10; z++) {
                    last_pattern[team_b][pattern_count[team_b]][z] = b_pattern[z];
                }
            
                pattern_count[team_a]++;
                pattern_count[team_b]++;
                
                
                total_score[team_a] += a_game_score;
                total_score[team_b] += b_game_score;

				System.out.println("<Game Result>");
                if (a_game_score == b_game_score) System.out.println("Draw\n");
                else System.out.println(String.format("Win: [%4s]!\n", a_game_score > b_game_score ? names[team_a] : names[team_b]));

            }
        }
        
        System.out.println("<Final score>");

        int max_inx = 0;
        int max_score = 0;
        
        for(int i=0; i<f_inx; i++) {

			System.out.println(String.format("[%4s] Total Score: %d", names[i], total_score[i]));
            
            if(max_score < total_score[i]) {
                max_inx = i;
                max_score = total_score[i];
            }
        }
        
        System.out.printf(String.format("<Winner: [%4s]!!!!>", names[max_inx]));
    }
}
