class create_intervals {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Keeps track of the maximum index reachable
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If we can't reach the current index, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable index
        }
        return true; // If we finish the loop, it means we can reach the last index
    }
}
