import java.util.*;

class text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Find how many words can fit in the current line
            while (last < words.length && totalChars + 1 + words[last].length() <= maxWidth) {
                totalChars += 1 + words[last].length(); // Add 1 for the space
                last++;
            }

            // Build the justified line
            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            int spacesToDistribute = maxWidth - totalChars + (numWords - 1);

            // If this is the last line OR only one word in the line -> left-align
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1)
                        sb.append(" ");
                }
                while (sb.length() < maxWidth)
                    sb.append(" "); // Pad remaining spaces
            } else {
                // Distribute spaces evenly
                int spaces = spacesToDistribute / (numWords - 1);
                int extraSpaces = spacesToDistribute % (numWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) { // If it's not the last word in the line
                        sb.append(" ".repeat(spaces + (extraSpaces-- > 0 ? 1 : 0)));
                    }
                }
            }

            result.add(sb.toString());
            index = last; // Move to the next line
        }

        return result;
    }
}
