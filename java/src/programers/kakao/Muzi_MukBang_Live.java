package programers.kakao;

import java.util.ArrayList;
import java.util.Arrays;

public class Muzi_MukBang_Live {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        System.out.println(solution(arr, 10));
    }

    public static int solution(int[] food_times, long k) {
        long max = 0;
        int min = 100000001;
        int minIdx = -1;

        if(k < food_times.length){ // 음식의 수보다 k 초가 적은 경우
            return (int) (k % food_times.length + 1);
        }
        else if(k == food_times.length){ // 음식의 수와 k초가 같은 경우
            for(int i=0; i<food_times.length; i++){
                if(food_times[i] != 1) return i+1;
            }
        }

        for(int i=0; i<food_times.length; i++){
            max += food_times[i];

            if(min > food_times[i]) {
                min = food_times[i];
                minIdx = i;
            }
        }

        if(k >= max) return -1; // k초가 지나기 전에 음식을 다 먹은 경우

        int value = food_times.length * min;
        ArrayList<Integer> list = new ArrayList<>();
        // 바로 계산 가능한 경우
        if(k - value < 0){
            return (int) (k % food_times.length + 1);
        }
        else if(k - value == 0){
            for(int i=minIdx; i< food_times.length; i++){
                if(food_times[i] != min) return i+1;
            }
        }
        else { // 비우고 시작 가능한 경우
            for(int i : food_times){
                list.add(i-min);
            }
            k -= min * food_times.length;
        }

        int cnt = 0;

        while (true){ // 리스트값 돌며 k초 후 음식 번호 찾기
            for(int i=0; i<list.size(); i++){
                int v = list.get(i);
                if(v == 0) continue;

                list.set(i, v-1);
                cnt++;

                if(k == cnt){ // 종료
                    for(int j=i+1; j<list.size(); j++){
                        if(list.get(j) != 0) return j+1;
                    }
                    for(int j=0; j<list.size(); j++){
                        if(list.get(j) != 0) return j+1;
                    }
                }
            }
        }
    }

}
