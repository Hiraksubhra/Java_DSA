import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(num);
            for (int prev : current) {
                next.add(prev | num);
            }
            result.addAll(next);
            current = next;
        }
        
        return result.size();
    }
}