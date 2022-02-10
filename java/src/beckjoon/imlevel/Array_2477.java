package beckjoon.imlevel;

import java.util.LinkedList;
import java.util.Scanner;

public class Array_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fruitNum = sc.nextInt();

        int maxIdx = 0;
        int secIdx;
        int thirdIdx;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<6; i++){
            sc.nextInt();
            list.add(sc.nextInt());
            if(list.get(i) >= list.get(maxIdx)){ maxIdx = i; }
        }

        // 가장 긴 변의 양옆 변 길이 구하기
        if(maxIdx == 0){
            if(list.get(maxIdx+1) > list.get(5)) { secIdx = maxIdx + 1; thirdIdx = 5; }
            else{ secIdx = 5; thirdIdx = maxIdx + 1; }
        }
        else if(maxIdx == 5){
            if(list.get(0) > list.get(maxIdx-1)) { secIdx = 0; thirdIdx = maxIdx -1; }
            else{ secIdx = maxIdx - 1; thirdIdx = 0; }
        }
        else {
            if(list.get(maxIdx+1) > list.get(maxIdx-1)) { secIdx = maxIdx + 1; thirdIdx = maxIdx -1; }
            else{ secIdx = maxIdx - 1; thirdIdx = maxIdx + 1; }
        }

        // 짧은 세로변
        int shortY = list.get(secIdx) - list.get(thirdIdx);
        int shortX = 0;

        // 짧은 가로변
        for(int i=0; i<6; i++){
            if(list.get(i) == list.get(thirdIdx)){
                if(thirdIdx == 0){
                    if(maxIdx == 5){ shortX = list.get(1); }
                    else { shortX = list.get(5); }
                }
                else if(thirdIdx == 5){
                    if(maxIdx == 0){ shortX = list.get(4); }
                    else { shortX = list.get(0); }
                }
                else {
                    if(maxIdx == thirdIdx +1){ shortX = list.get(thirdIdx -1); }
                    else { shortX = list.get(thirdIdx +1); }
                }
            }
        }

        int totalField = list.get(maxIdx) * list.get(secIdx);
        int minusField = shortX * shortY;

        int field = totalField - minusField;
        System.out.println(fruitNum * field);
    }
}
