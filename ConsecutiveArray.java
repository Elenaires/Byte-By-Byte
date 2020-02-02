// O(nlgn) solution
// O(n) solution uses hashset 
class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        Arrays.sort(nums);
        int maxLength = 1;
        int current = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j-1]) {
                continue;
            }
            
            if(nums[j] == nums[j-1] + 1) {
                current++;
                maxLength = Math.max(current, maxLength);
            }
            else {
                current = 1;
            }
        }
        
        return maxLength;
    }
}