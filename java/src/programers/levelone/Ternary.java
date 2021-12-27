package programers.levelone;

import java.util.*;

public class Ternary {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(true){
            if(n<3){
                sb.append(n);
                break;
            }
            sb.append(n%3);
            n /= 3;
        }
        System.out.println(Integer.parseInt(String.valueOf(sb), 3));

//        int[] num = ternary(n);
//        int total = 0;
//
//        // 2 2 1 1 1
//        // [] 0 1 2 3 4
//        for(int i=0; i<num.length; i++){
//            int three = 1;
//            if(i == 0){
//                total = three * num[i];
//            } else {
//                for(int j=0; j<i; j++){
//                    three = three * 3; // 3, 9
//                }
//                total += num[i] * three;
//            }
//        }
//
//        System.out.println(total);
    }

    public static int[] ternary(int n){
        int var = n;
        List<Integer> list = new ArrayList<>();

        while (true){
            if(var < 3){
                list.add(var);
                break;
            }

            list.add(var % 3);
            var /= 3;
        }
        int[] num = new int[list.size()];
        Collections.reverse(list);

        for(int i=0; i<num.length; i++){
            num[i] = list.get(i);
            System.out.print(list.get(i));
        }

        System.out.println();
        return num;
    }

}
