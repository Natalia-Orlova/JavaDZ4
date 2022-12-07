package lesson4;

//https://leetcode.com/problems/01-matrix/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TaskOne {
    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        int[][] ans = new int[mat.length][mat[0].length];
        for (int[] num : ans) {
            Arrays.fill(num, -1);
        }

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    q.add(new int[] {row, col});
                    ans[row][col] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];
                if (check(newRow, newCol, mat.length, mat[0].length)
                        && ans[newRow][newCol] == -1) {
                    q.add(new int[] {newRow, newCol});
                    ans[newRow][newCol] = ans[curRow][curCol] + 1;
                }
            }
        }
        return ans;
    }

    public boolean check (int i, int j, int m, int n) {
        return (i >= 0 && j >= 0 && i < m && j < n);
    }
}

//public class TaskOne {
//
//    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//    public int[][] updateMatrix(int[][] mat) {
//
//        Queue<int[]> q = new LinkedList<>();
//        int[][] ans = new int[mat.length][mat[0].length];
//        for (int[] num : ans) {
//            Arrays.fill(num, -1);
//        }
//        System.out.println(ans);
//
//        for (int row = 0; row < mat.length; row++) {
//            for (int col = 0; col < mat[0].length; col++) {
//                if (mat[row][col] == 0) {
//                    q.add(new int[] {row, col});
//                    ans[row][col] = 0;
//                }
//            }
//        }
//
//        while (!q.isEmpty()) {
//            int[] curPoint = q.poll();
//            int curRow = curPoint[0];
//            int curCol = curPoint[1];
//            for (int[] direction : DIRECTIONS) {
//                int newRow = curRow + direction[0];
//                int newCol = curCol + direction[1];
//                if (newRow < 0 || newCol < 0 || newRow >= mat.length ||
//                        newCol >= mat[0].length ||
//                        mat[newRow][newCol] <= mat[curRow][curCol] + 1) {
//                    continue;
//                }
//                q.add(new int[] {newRow, newCol});
//                mat[newRow][newCol] = mat[curRow][curCol] + 1;
//            }
//        }
//        return mat;
//    }
//}



