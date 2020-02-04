// k - number of arrays, n - elements in each array
// O(knlogk) - add all elements to minHeap
// O(knlogk) - remove all elements from minHeap
// Overall complexity = O(knlogk)

import java.util.*;

public class MergeKSortedArrayPriorityQueue {
    
    private static class Node {
        int array;
        int index;
        int value;

        public Node(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args){

        int[][] arrays = new int[][]{{1,2,10},{4,5,6},{7,8,9},{0,3,5}};

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> (a.value - b.value));

        int size = 0;
        for(int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
            minHeap.add(new Node(i, 0, arrays[i][0])); // max size is k
        }

        int[] result = new int[size];
        int i = 0;

        while(!minHeap.isEmpty()) {
            Node node = minHeap.remove();
            result[i++] = node.value;
            if(node.index + 1 < arrays[node.array].length) {
                Node newNode = new Node(node.array, node.index+1, arrays[node.array][node.index+1]);
                minHeap.add(newNode);
            }
        }
        
        for(int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        }
        System.out.println();
    }
}