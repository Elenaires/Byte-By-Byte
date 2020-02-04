// O(knlogk)
// first iteration k/2 * 2n = kn
// 2nd iteration k/4 * 4n = kn
// we repeat for logk times since we half the size each iteration

public class MergeKSortedArrayOptimised {
    public static void main(String[] args){
        int[][] arrays = new int[][]{{1,2,10},{4,5,6},{7,8,9},{3,3,5}};

        //****** LEARN THIS *******/
        int interval = 1;
        while(interval < arrays.length) {
            for(int i = 0; i + interval < arrays.length; i+=interval*2) {
                arrays[i] = mergeTwoArrays(arrays[i], arrays[i+interval]);
            }
            interval*=2;
        }
        //**************************/
        
        for(int i = 0; i < arrays[0].length; i++) {
            System.out.print(arrays[0][i] + " ");
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