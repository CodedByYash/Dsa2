import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS_BinarySearch(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int pos = binarySearch(sub, num);
            if (pos == sub.size()) {
                sub.add(num); // Extend the subsequence
            } else {
                sub.set(pos, num); // Replace the element at position
            }
        }

        return sub.size();
    }

    private static int binarySearch(List<Integer> sub, int target) {
        int left = 0, right = sub.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sub.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // Position to insert or replace
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println("Length of LIS (Binary Search): " + lengthOfLIS_BinarySearch(nums)); // Output: 4
    }
}
