package swexpertacademy.queue;

public class BFS_practice {
    public static int G[][] = {
            { 0, 0, 0 },
            { 2, 3, 0 }, // 정점 1의 인접정점
            { 1, 4, 5 }, // 정점 2의 인접정점
            { 1, 7, 0 }, // 정점 3의 인접정점
            { 2, 6, 0 }, // 정점 4의 인접정점
            { 2, 6, 0 }, // 정점 5의 인접정점
            { 4, 5, 7 }, // 정점 6의 인접정점
            { 3, 6, 0 } };  // 정점 7의 인접정점
    static boolean[] visited = new boolean[8];
    static int[] q = new int[10];
    static int f, r;

    public static void main(String[] args) {
        f = r = -1;
        BFS(1);
    }

    static void BFS(int v) {
        System.out.printf("%d", q[++r] = v);
        visited[v] = true;

        while(f != r){
            v = q[++f];
            for(int i=0; i<3; i++){
                if(G[v][i] > 0 && !visited[G[v][i]])
                {
                    System.out.printf("%d", q[++r] = G[v][i]);
                    visited[G[v][i]] = true;
                }
            }
        }
    }


}
