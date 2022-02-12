package beckjoon.bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class NumSequence_2635 {
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxSize = 0;
        int maxidx = 0;

        for(int i=1; i<=n; i++){
            list = new ArrayList<>();
            list.add(n); list.add(i);

            while(list.get(list.size()-1) >= 0){
                list.add(list.get(list.size()-2) - list.get(list.size()-1));
            }
            if(list.size() > maxSize){
                maxSize = list.size();
                maxidx = i;
            }
        }

        list = new ArrayList<>();
        list.add(n); list.add(maxidx);

        while(list.get(list.size()-1) >= 0){
            list.add(list.get(list.size()-2) - list.get(list.size()-1));
        }
        list.remove(list.size()-1);

        System.out.println(list.size());
        for(int i : list) System.out.print(i + " ");
    }
}
