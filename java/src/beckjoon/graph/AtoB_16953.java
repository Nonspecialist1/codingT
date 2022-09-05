package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AtoB_16953 {

    static int A, B;
    public static class Value{
        int val;
        int cnt;

        Value(int val, int cnt){
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(-1);
    }

    private static void BFS(){
        Queue<Value> q = new LinkedList<>();
        q.add(new Value(A, 0));

        while (!q.isEmpty()){
            Value v = q.poll();

            if(v.val == B){ // 둘이 같다면
                System.out.println(v.cnt + 1);
                System.exit(0);
            }

            try {
                int multiply = v.val * 2;
                if(multiply < 0 || multiply > B) continue;

                q.add(new Value(multiply, v.cnt+1));
            } catch (Exception e){
                continue;
            }

            try {
                String str = v.val + "1";
                int plusOne = Integer.valueOf(str);
                if(plusOne > B) continue;

                q.add(new Value(plusOne, v.cnt+1));
            } catch (Exception e){
                continue;
            }
        }
    }

}
