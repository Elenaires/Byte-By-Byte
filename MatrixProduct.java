//Question:​ Given a matrix, find the path from top left to bottom right with the greatest product by moving only down and right.

// brute force O(2^n) where n is the depth of the recursion tree

import java.util.*;
public class MatrixProduct 
{
	static int maxValue = 0;
	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		dfs(matrix, 1, 0, 0, list, result);
		
		System.out.println(maxValue);
		for(int k = 0; k < result.size(); k++) {
			System.out.print(result.get(k) + " ");
		}
		System.out.println();
	}

	public static void dfs(int[][] array, int max, int i, int j, List<Integer> list, List<Integer> result) {
		int[][] shift = new int[][]{{1,0}, {0,1}};
		max *= array[i][j];
		list.add(array[i][j]);

		if(i == array.length-1 && j == array[0].length-1) {
			if(maxValue < max) {
				maxValue = max;
				result.clear();
				result.addAll(list);
			}
		}
		else {
			for(int[] s : shift) {
				int newI = i + s[0];
				int newJ = j + s[1];
				if(isFeasible(array, newI, newJ)) {
					dfs(array, max, newI, newJ, list, result);
				}
			}
		}
		list.remove(list.size()-1);
	}

	private static boolean isFeasible(int[][] array, int i, int j) {
		if(i < 0 || i >= array.length || j < 0 || j >= array[0].length) {
			return false;
		}
		return true;
	}
}
