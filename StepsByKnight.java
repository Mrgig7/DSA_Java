import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        KnightPos[0]--;
        KnightPos[1]--;
        TargetPos[0]--;
        TargetPos[1]--;

        boolean v[][] = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{KnightPos[0], KnightPos[1], 0});
        v[KnightPos[0]][KnightPos[1]] = true;
        int[][] directions = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == TargetPos[0] && cur[1] == TargetPos[1]) {
                return cur[2];
            }
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < N && y >= 0 && y < N && !v[x][y]) {
                    v[x][y] = true;
                    q.add(new int[]{x, y, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StepsByKnight km = new StepsByKnight();
        int N = 3;
        int[] KnightPos = {3, 3};
        int[] TargetPos = {2, 1};
        System.out.println(km.minStepToReachTarget(KnightPos, TargetPos, N));
}
