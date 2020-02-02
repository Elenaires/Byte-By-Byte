// Question 6:​ Given a boolean matrix, update it so that if any cell is true, 
// all the cells in that row and column are true.
// O(n x m x (n + m))

class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) { // O(n)
            for(int j = 0; j < matrix[0].length; j++) { // O(m)
                if(matrix[i][j] == 0) {
                    markMatrix(i, j, matrix); // O(m + n)
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1000000) {
                   matrix[i][j] = 0;
                }
            }
        }
    }
    
    private void markMatrix(int row, int col, int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] =  matrix[row][i] == 0 ? 0 : -1000000;
        }
        
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = matrix[i][col] == 0 ? 0 : -1000000;
        }
    }
}