package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class List2_partSum_4837 {
    // 전체 집합
    static int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void main(String[] args) throws IOException {
        for(int i=1; i<=3; i++)
        {
            for(int j=1; j<=3; j++)
            {
                if(j != i)
                {
                    for(int k=1; k<=3; k++){
                        if(k != i && k != j){ System.out.println(i + " " + j + " " + k); }
                    }
                }
            }
        }

    }
}
