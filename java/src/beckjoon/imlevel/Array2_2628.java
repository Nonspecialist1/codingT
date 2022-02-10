package beckjoon.imlevel;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Array2_2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        LinkedList<Integer> listRow = new LinkedList<>();
        LinkedList<Integer> listCol = new LinkedList<>();
        listRow.add(row);
        listRow.add(0);
        listCol.add(col);
        listCol.add(0);

        int T = sc.nextInt(); // 자르는 횟수

        while(T != 0){
            int dir = sc.nextInt(); // 자르는 방향
            int idx = sc.nextInt(); // 자르는 번호
            if(dir == 0){ // 가로로 자름 (col 에서 끊기)
                listCol.add(idx);
            }
            else { // 세로로 자름 (row 에서 끊기)
                listRow.add(idx);
            }
            T--;
        }
        // 오름차순 정렬
        listRow.sort(Comparator.naturalOrder());
        listCol.sort(Comparator.naturalOrder());

        int maxCol = 0;
        for(int i=listCol.size()-1; i>0; i--){ // 가장 긴 세로 길이 구하기
            int max = listCol.get(i) - listCol.get(i-1);
            if(max > maxCol){ maxCol = max; }
        }

        int maxRow = 0;
        for(int i=listRow.size()-1; i>0; i--){ // 가장 긴 가로 길이 구하기
            int max = listRow.get(i) - listRow.get(i-1);
            if(max > maxRow){ maxRow = max; }
        }

        System.out.println(maxCol * maxRow);
    }
}
