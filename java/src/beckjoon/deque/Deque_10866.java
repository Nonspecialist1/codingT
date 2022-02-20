package beckjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Deque_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();;

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String n;
            switch (s){
                case "push_back":
                    n = st.nextToken();
                    deque.addLast(n);
                    break;
                case "push_front":
                    n = st.nextToken();
                    deque.addFirst(n);
                    break;
                case "front":
                    if(deque.isEmpty()){ System.out.println(-1); }
                    else { System.out.println(deque.peekFirst()); }
                    break;
                case "back":
                    if(deque.isEmpty()){ System.out.println(-1); }
                    else { System.out.println(deque.peekLast()); }
                    break;
                case "size": System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()){ System.out.println(1); }
                    else { System.out.println(0); }
                    break;
                case "pop_front":
                    if(deque.isEmpty()){ System.out.println(-1); }
                    else { System.out.println(deque.pollFirst()); }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){ System.out.println(-1); }
                    else { System.out.println(deque.pollLast()); }
                    break;
            }
        }
    }
}

