package algoexam.kakao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Blind_2023_1 {
    // 풀었음

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

    public static void main(String[] args) throws ParseException {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] answer = solution(today, terms, privacies);
        for(int i : answer){
            System.out.println(i);
        }
    }

    static public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i< privacies.length; i++){ // 개인정보 데이터마다 날짜와 유형 구하기
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            String day = st.nextToken();
            String type = st.nextToken();

            for(String term : terms){ // 개인정보 유형마다 유효기간 구하기
                st = new StringTokenizer(term, " ");
                String alphabet = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(alphabet.equals(type)){ // 같은 약관이라면 폐기날짜 구하기
                    String expireDay = getExpiredDate(day, num);
                    System.out.println(expireDay);
                    // 현재날짜와 폐기날짜 비교
                    boolean result = compareDate(today, expireDay);
                    if(result){ // 만료된 경우 값 저장
                        list.add(i+1);
                    }
                }
            }
        }
        // 배열에 값 채우기
        int[] answer = new int[list.size()];
        int idx = 0;

        for(int i : list){
            answer[idx++] = i;
        }

        return answer;
    }

    static private String getExpiredDate(String day, int num) throws ParseException {
        Date date = dateFormat.parse(day);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 월 더하기
        cal.add(Calendar.MONTH, num);

        return dateFormat.format(cal.getTime());
    }

    static private boolean compareDate(String today, String expireDay) throws ParseException {
        Date now = dateFormat.parse(today);
        Date expire = dateFormat.parse(expireDay);
        // 유효기간이 지난 남은 경우 트루 반환
        int result = expire.compareTo(now);

        if(result <= 0) return true;
        else return false;
    }

}
