//Question:​ Given a matrix, find the path from top left to bottom right with the greatest product by moving only down and right.

// DP Time complexity O(n^2) where n is the size of the 1D array.
// Space complexity O(n^2) since we create cached arrays.

// Question: how to print the path??

import java.util.*;
public class MatrixProductOptimized 
{
	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,-9}};
		int maxValue = calcMaxProduct(matrix);
		System.out.println(maxValue);
	}

	public static int calcMaxProduct(int[][] array) {

		int[][] minCache = new int[array.length][array[0].length];
		int[][] maxCache = new int[array.length][array[0].length];

	
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(i == 0 && j == 0) {
					minCache[i][j] = array[i][j];
					maxCache[i][j] = array[i][j];
				}
				else {
					if(i == 0) {
						minCache[i][j] = array[i][j] * minCache[i][j-1];
						maxCache[i][j] = array[i][j] * maxCache[i][j-1];
					}
					else if (j == 0) {
						minCache[i][j] = array[i][j] * minCache[i-1][j];
						maxCache[i][j] = array[i][j] * maxCache[i-1][j];
					}
					else {
						// look up
						int max = Math.max(array[i][j] * maxCache[i-1][j], array[i][j] * minCache[i-1][j]);
						int min = Math.min(array[i][j] * maxCache[i-1][j], array[i][j] * minCache[i-1][j]);

						// look left
						max = Math.max(max, Math.max(array[i][j] * maxCache[i][j-1], array[i][j] * minCache[i][j-1]));
						min = Math.min(min, Math.min(array[i][j] * maxCache[i][j-1], array[i][j] * minCache[i][j-1]));
						
						minCache[i][j] = min;
						maxCache[i][j] = max;
					}

				}
			}
		}

		return maxCache[maxCache.length-1][maxCache[0].length-1];
	}
}
