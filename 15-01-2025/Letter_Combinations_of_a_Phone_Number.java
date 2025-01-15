import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> digitToChar = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        List<String> result = new ArrayList<>();
        backtrack(digits, digitToChar, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, Map<Character, String> digitToChar, int index,
            StringBuilder currentCombination, List<String> result) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        String possibleChars = digitToChar.get(digits.charAt(index));
        for (char c : possibleChars.toCharArray()) {
            currentCombination.append(c);
            backtrack(digits, digitToChar, index + 1, currentCombination, result);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // Backtrack
        }
    }
}