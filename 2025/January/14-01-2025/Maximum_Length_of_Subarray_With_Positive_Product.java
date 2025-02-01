class Maximum_Length_of_Subarray_WIth_Positive_Product {
    public int getMaxLen(int[] nums) {
        int posLen = 0; // Tracks positive product length
        int negLen = 0; // Tracks negative product length
        int maxLen = 0; // Tracks maximum positive product length

        for (int num : nums) {
            if (num == 0) {
                posLen = 0; // Reset lengths on 0
                negLen = 0;
            } else if (num > 0) {
                posLen += 1; // Positive number extends posLen
                negLen = (negLen > 0) ? negLen + 1 : 0; // Extend negLen if valid
            } else {
                int temp = posLen; // Swap posLen and negLen
                posLen = (negLen > 0) ? negLen + 1 : 0;
                negLen = temp + 1;
            }

            maxLen = Math.max(maxLen, posLen); // Update max length
        }

        return maxLen;
    }
}
