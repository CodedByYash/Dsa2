public class sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x; // Edge case

        int left = 1, right = x / 2, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x)
                return mid; // Exact square root
            else if (square < x) {
                ans = mid; // Store possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans; // Return the integer part of sqrt(x)
    }
}
