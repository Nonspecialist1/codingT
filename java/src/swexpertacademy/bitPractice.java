package swexpertacademy;

public class bitPractice {
    public static void main(String[] args) {
        // 공집합은 제외시키기 위해 i=1 부터, 공집합의 합을 물어보는 게 맞냐
        int arr[] = {-1, 3, -9, 6, 7, -6, 1, 5, 4, -2};
        int count = 0;

        String[] str = new String[1024];

        for(int i = 1; i < (1 << 10); i++) //공집합 제외
        {
            StringBuilder sb = new StringBuilder();
            //System.out.printf("[ %d ] ", ++count);
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(arr[j] + " ");
                }
            }
            str[i] = sb.toString();
        }
        int i = 0;
        for(String s : str){
            System.out.println(++i + " : " + s);
        }
    }
}
