package swexpertacademy.stack;

import java.util.LinkedList;

public class StackImplement {
    public static void main(String[] args) {
        StackImp<Character> st = new StackImp();
        st.push('(');
        char c = st.pop();
        System.out.println(c);
        st.push('{');
        st.push('[');
        System.out.println(st.pop());
    }
}

class StackImp<E> {
    LinkedList<E> list = new LinkedList<>();
    int top = -1;

    void push(E obj){
        list.add(obj);
        top += 1;
    }

    E pop(){
        if(list.size() == 0){ System.out.println("스택이 비었습니다"); return null; }
        E e = list.get(top);
        list.remove(top);
        top -= 1;
        return e;
    }

}