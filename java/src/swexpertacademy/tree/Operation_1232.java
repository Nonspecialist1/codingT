package swexpertacademy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String op;
    int data;
    int left;
    int right;
}

public class Operation_1232 {
    static Node[] node;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            N = Integer.parseInt(br.readLine()) + 1;
            node = new Node[N];
            for(int i=1; i<N; i++) node[i] = new Node();

            for (int i=1; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()); // 정점번호
                String val = st.nextToken(); // 정점에 해당하는 값

                if(val.equals("*") || val.equals("/") || val.equals("-") || val.equals("+")){ node[idx].op = val; }
                else{ node[idx].data = Integer.parseInt(val); }
                while (st.hasMoreTokens()) { // 간선이 있다면
                    node[idx].left = Integer.parseInt(st.nextToken());
                    node[idx].right = Integer.parseInt(st.nextToken());
                }
            }
            System.out.printf("#%d %d\n", T, getAnswer(1));
        }
    }
    static int getAnswer(int idx){
        String op = node[idx].op;
        if(op != null){
            switch (op){
                case "*":
                    result = getAnswer(node[idx].left) * getAnswer(node[idx].right); break;
                case "/":
                    result = getAnswer(node[idx].left) / getAnswer(node[idx].right); break;
                case "+":
                    result = getAnswer(node[idx].left) + getAnswer(node[idx].right); break;
                case "-":
                    result = getAnswer(node[idx].left) - getAnswer(node[idx].right); break;
            }
            return result;
        }
        else { result = node[idx].data; }
        return result;
    }
}
