public class Largest_Number {
    import java.util.*;
    public String largestNumber(int[] nums) {
        // Convert the integer array to a String array
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort the strings based on concatenated order
        Arrays.sort(stringNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (stringNums[0].equals("0")) {
            return "0";
        }

        // Build the result by concatenating all strings
        StringBuilder result = new StringBuilder();
        for (String num : stringNums) {
            result.append(num);
        }

        return result.toString();
    }
}
