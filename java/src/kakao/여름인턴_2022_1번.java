package kakao;

public class 여름인턴_2022_1번 {
    // 풀었음

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choice));
    }

    static int[][] Indicator = new int[4][2];

    static void check(String s, int score){
        switch (s){
            case "R" : Indicator[0][0] += score;
                break;
            case "T" : Indicator[0][1] += score;
                break;
            case "C" : Indicator[1][0] += score;
                break;
            case "F" : Indicator[1][1] += score;
                break;
            case "J" : Indicator[2][0] += score;
                break;
            case "M" : Indicator[2][1] += score;
                break;
            case "A" : Indicator[3][0] += score;
                break;
            case "N" : Indicator[3][1] += score;
                break;
        }
    }

    static public String solution(String[] survey, int[] choices) {
        String answer = "";

        for(int i=0; i<survey.length; i++){
            int num = choices[i];
            if(num == 4){ continue; }

            char[] ch = survey[i].toCharArray();
            int score = Math.abs(4 - num);

            if(num < 4){
                String s = String.valueOf(ch[0]);
                check(s, score);
            }
            else if(num > 4){
                String s = String.valueOf(ch[1]);
                check(s, score);
            }
        }
        // 지표 검사
        for(int i=0; i<4; i++){
            if(Indicator[i][0] >= Indicator[i][1]){
                switch (i){
                    case 0 : answer += "R";
                        break;
                    case 1 : answer += "C";
                        break;
                    case 2 : answer += "J";
                        break;
                    case 3 : answer += "A";
                        break;
                }
            }
            else {
                switch (i) {
                    case 0:
                        answer += "T";
                        break;
                    case 1:
                        answer += "F";
                        break;
                    case 2:
                        answer += "M";
                        break;
                    case 3:
                        answer += "N";
                        break;
                }
            }
        }
        return answer;
    }


}
