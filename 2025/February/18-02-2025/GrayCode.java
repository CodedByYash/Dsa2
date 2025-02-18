import java.util.*;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        for (int i = 0; i < n; i++) {
            int addValue = 1 << i;
            int size = result.size();

            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) + addValue);
            }
        }

        return result;
    }
}