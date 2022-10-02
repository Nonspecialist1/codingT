package programers.levelfour;

import java.util.*;

public class Muzi_MukBang_Live {

    private static class Food implements Comparable<Food>{
        int idx, time;

        public Food(int idx, int time){
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 1, 4};
        System.out.println(solution(arr, 12));
    }

    public static int solution(int[] food_times, long k) {
        long max = 0;
        long length = food_times.length;  // 남은 음식 개수

        if(k < length) return (int) k+1; // k가 음식의 수보다 적을 때

        LinkedList<Food> foods = new LinkedList<>();
        for(int i=0; i<length; i++){
            max += food_times[i];
            foods.add(new Food(i+1, food_times[i]));
        }
        if(k >= max) return -1; // k초가 지나기 전에 음식을 다 먹은 경우

        Collections.sort(foods);
        int cnt = 0;

        while ((foods.get(0).time - cnt) * length < k){
            k -= (foods.get(0).time - cnt) * length;
            cnt = foods.get(0).time;
            foods.remove(0);
            length--;
        }

        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.idx - o2.idx;
            }
        });

        return foods.get((int) (k % length)).idx;
    }
}
