import java.util.*;

public class simplify_path {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String dir : components) {
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop(); // Go up one directory
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.push(dir); // Valid directory
            }
        }

        return "/" + String.join("/", stack); // Join stack to form the path
    }
}