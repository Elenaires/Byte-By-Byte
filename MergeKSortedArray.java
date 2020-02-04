// O(2n+3n+4n+...+kn) = O(nk^2)

public class MergeKSortedArray {
    public static void main(String[] args){
        int[][] arrays = new int[][]{{1,2,10},{4,5,6},{7,8,9},{3,3,5},{2,4,8}};

        //int[] main = merge(arrays[0], arrays[1]);
        int[] main = arrays[0];
        for(int i = 1; i < arrays.length; i++) {
            main = mergeTwoArrays(main, arrays[i]);
        }

        for(int i = 0; i < main.length; i++) {
            System.out.print(main[i] + " ");
        }
        System.out.println();
    }

    public static int[] mergeTwoArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        
        int i = 0;
        int j = 0; 
        int k = 0;

        while(i < array1.length && j < array2.length) {
            result[k++] = array1[i] < array2[j] ? array1[i++] : array2[j++];
        }

        while(i < array1.length) {
            result[k++] = array1[i++];
        }
        while(j < array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }
}