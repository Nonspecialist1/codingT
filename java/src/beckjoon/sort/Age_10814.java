package beckjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Age_10814 {

    public static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o){
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            person[i] = new Person(age, name);
        }

        Arrays.sort(person);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(person[i].age + " " + person[i].name + "\n");
        }
        System.out.print(sb);
    }
}
