import java.util.*;

public class LuckyNumbersInAMatrix {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int mr = matrix[i][0];
            int mri = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < mr) {
                    mr = matrix[i][j];
                    mri = j;
                }
            }
            boolean ismc = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][mri] > mr) {
                    ismc = false;
                    break;
                }
            }
            if (ismc) {
                luckyNumbers.add(mr);
            }
        }
        return luckyNumbers;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        List<Integer> result = luckyNumbers(matrix);
        System.out.println(result); 
}
