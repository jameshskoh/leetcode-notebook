package ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hits = new HashSet<>();

        for (int num : nums) {
            if (hits.contains(num)) return true;

            hits.add(num);
        }

        return false;
    }
}
