package beckjoon.stack;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class IronBar_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        String str = br.readLine().replace("()", "0");
        char[] arr = str.toCharArray();
        int lazer = 0;
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == ')'){
                while(true){
                    char c = st.pop();
                    if(c == '0') lazer++;
                    else{
                        for(int j=0; j<list.size(); j++){
                            list.set(j, list.get(j) + lazer);
                        }
                        ans += list.get(0) +1 ;
                        list.remove(0);
                        lazer = 0;
                        break;
                    }
                }
            }
            else {
                if(arr[i] == '('){ list.add(0, 0); }
                st.push(arr[i]);
            }
        }
        System.out.println(ans);
    }
}


