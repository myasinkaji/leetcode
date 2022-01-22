package ir.home.tutorial.algorithm.recursive;

import java.util.HashMap;
import java.util.Map;

public class Recursive {
    private final Map<Integer, Long> calculatedValues = new HashMap<>();

    int p1CallCount = 0;
    int p1AddCount = 0;
    int p1MultCount = 0;

    public long p1(int n) {
        p1CallCount++;
        if (calculatedValues.containsKey(n)) {
            if (n <= 1)
                p1MultCount++;
            else
                p1AddCount += 2;

            return calculatedValues.get(n);
        }

        long result;
        if (n <= 1) {
            result = n * n;
            p1MultCount++;
        } else {
            result = p1(n - 1) + p1(n - 2) + n;
            p1AddCount += 2;
            calculatedValues.put(n, result);
        }

        return result;
    }
}
