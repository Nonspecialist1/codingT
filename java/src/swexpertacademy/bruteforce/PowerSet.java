package swexpertacademy.bruteforce;

import java.util.ArrayList;

public class PowerSet {
    static int[] Set = {-1, 3, -9, 6, 7, -6, 1, 5, 4, -2};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        powerSet(0);
    }

    static void powerSet(int cnt){
        if(cnt == Set.length){
            int sum = 0;
            for(int i : list){ sum += i; }

            if(sum == 0){
                for(int i : list) System.out.printf("%d ", i);
                System.out.println();
            }
            return;
        }
        else {
            list.add(Set[cnt]);
            powerSet(cnt + 1);
            list.remove(list.size()-1);
            powerSet(cnt + 1);
        }
    }


}
