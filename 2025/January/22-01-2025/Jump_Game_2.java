public class Jump_Game_2 {
    public int jump(int[] nums) {
        int jumps = 0; // Number of jumps
        int currentEnd = 0; // The range of the current jump
        int farthest = 0; // The farthest we can reach

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // Move to the next jump range

                // Optimization: If we can already reach the end, break
                if (currentEnd >= nums.length - 1)
                    break;
            }
        }

        return jumps;
    }
}