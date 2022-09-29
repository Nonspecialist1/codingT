package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateMin_1541 {

    private static String[] Nums;
    private static int Answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Nums = br.readLine().split("-");

        getPlus();
        getSum();

        System.out.println(Answer);
    }

    private static void getPlus(){ // 각 인덱스의 숫자들 더해주기
        for(int i=0; i< Nums.length; i++){
            String[] plusValue = Nums[i].split("\\+");

            if(plusValue.length == 1){ // 단항인 경우 넘어감
                continue;
            }
            else { // 더하기가 있는 경우
                int sum = 0;
                for(int j=0; j< plusValue.length; j++){
                    int v = Integer.parseInt(plusValue[j]);
                    sum += v;
                }
                // 다 더한 경우 Nums 값에 갱신하기
                Nums[i] = String.valueOf(sum);
            }
        }
    }

    private static void getSum(){ // 최솟값 구하기
        Answer = Integer.parseInt(Nums[0]);

        for(int i=1; i< Nums.length; i++){
            int v = Integer.parseInt(Nums[i]);
            Answer -= v;
        }
    }

}
