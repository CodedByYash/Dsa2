public class Zigzag_Conversion {
    public String convert(String s, int numRows) {
        // Edge case: If numRows is 1, return the string itself
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a StringBuilder array for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction at the top and bottom rows
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
