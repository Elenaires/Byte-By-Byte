// Question 4:​ Given an array of integers where each value 1 <= x <= len(array), 
// write a function that finds all the duplicates in the array.
// not a good solution
// uses extra space, its not exactly a one pass solution - multiple swaps
// good solution: manipulate the array by marking a 'used' position with -ve

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList();
        HashSet<Integer> set = new HashSet();
        
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i+1) {
                i++;
            }
            else {
                if(nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
                else {
                    if(!set.contains(nums[i])) {
                        set.add(nums[i]);
                        list.add(nums[i]);
                    }
                    i++;
                }
            }
        }
        
        return list;
    }
}