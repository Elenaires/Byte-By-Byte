public class MatrixProduct 
{
	static int maxValue = 0;
	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{{-1,2,3},{4,5,-6},{7,8,100}};
		

		dfs(matrix, 1, 0, 0);
		
		System.out.println(maxValue);	
		
	}

	public static void dfs(int[][] array, int max, int i, int j) {
		int[][] shift = new int[][]{{1,0}, {0,1}};

		if(i == array.length-1 && j == array[0].length-1) {
			max *= array[i][j];
			maxValue = Math.max(maxValue, max);
		}
		else {
			max *= array[i][j];
			for(int[] s : shift) {
				int newI = i + s[0];
				int newJ = j + s[1];
				if(isFeasible(array, newI, newJ)) {
					dfs(array, max, newI, newJ);
				}
			}
		}
	}

	private static boolean isFeasible(int[][] array, int i, int j) {
		if(i < 0 || i >= array.length || j < 0 || j >= array[0].length) {
			return false;
		}
		return true;
	}
}
