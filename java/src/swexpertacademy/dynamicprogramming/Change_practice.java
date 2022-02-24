package swexpertacademy.dynamicprogramming;

public class Change_practice {
    static int[] D = { 0, 1, 5, 10, 16 };
    static int[][] C;

    public static void main(String[] args) {
        C = new int[5][21];

        for(int j=0; j<21; j++){
            C[0][j] = 100;
        }

        for(int i=1; i<5; i++){
            for(int j=1; j<21; j++){
                if(j < D[i]) C[i][j] = C[i-1][j];
                else C[i][j] = Math.min(C[i][j-D[i]]+1, C[i-1][j]);
            }
        }

        for(int i=1; i<5; i++){
            for(int j=1; j<21; j++){
                System.out.printf("%3d", C[i][j]);
            }
            System.out.println();
        }


    }
}
