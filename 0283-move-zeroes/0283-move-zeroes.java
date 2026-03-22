class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // pointer for non-zero placement

        // move non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }

        // fill remaining with zeros
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}