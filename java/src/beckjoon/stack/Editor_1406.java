package beckjoon.stack;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Editor_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>();

        String s = br.readLine();
        for(int i=0; i<s.length(); i++){ list.add(s.charAt(i)); }

        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext()){
            iter.next();
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String str = br.readLine();
            char c = str.charAt(0);
            switch (c){
                case 'L': if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D': if(iter.hasNext()) iter.next();
                    break;
                case 'B': if(iter.hasPrevious()) { iter.previous(); iter.remove(); }
                    break;
                case 'P':
                    char plus = str.charAt(2);
                    iter.add(plus);
                    break;
            }
        }

        for(Character c : list){ bw.write(c); }
        bw.flush();
        bw.close();
    }
}


