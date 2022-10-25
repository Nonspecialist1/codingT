package programers.leveltwo;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum_42839 {

    static char[] nums;
    static boolean[] primeNum, Visit = new boolean[8];
    static int answer;
    static Set<String> set = new HashSet<>();

    public int solution(String numbers) {
        answer = 0;
        // 소수 1천만까지 구하기
        int max = 10000000;
        primeNum = new boolean[max+1];
        primeNum[1] = true;
        // 2부터 특정 배수는 다 true
        for(int i=2; i<=max; i++){
            if(primeNum[i]) continue;
            // 아직 ture 가 아닌 숫자
            for(int j=2*i; j<=max; j+=i){
                primeNum[j] = true;
            }
        }

        // 입력값 배열 만들기
        nums = numbers.toCharArray();
        subset(0, new StringBuilder());

        return answer;
    }

    private static void subset(int idx, StringBuilder sb){
        if(idx == nums.length){
            printArr(sb);
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(Visit[i]) continue;

            sb.append(nums[i]);

            Visit[i] = true;
            subset(idx+1, sb);
            Visit[i] = false;

            sb.deleteCharAt(sb.length() - 1);
        }
        subset(idx+1, sb);
    }

    private static void printArr(StringBuilder sb){
        String str = "";
        for(int i=0; i<sb.length(); i++){
            if(str == "" && sb.charAt(i) == '0') continue;
            else str += sb.charAt(i);
        }

        if(str != "" && !primeNum[Integer.valueOf(str)] && !set.contains(str)){
            set.add(str);
            answer++;
        }
    }

}
