class pow {
    public double myPow(double x, int n) {
        // Handle negative powers
        long N = n; // Use long to handle overflow for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            // If the current power is odd, multiply it into the result
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            // Square the current product for the next iteration
            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
}