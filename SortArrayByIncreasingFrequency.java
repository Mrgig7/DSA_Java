import java.util.*;

public class SortArrayByIncreasingFrequency {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> mp = new HashMap<>();
            
            for (int num : nums) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
            
            List<Map.Entry<Integer, Integer>> li = new ArrayList<>(mp.entrySet());
            li.sort((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return b.getValue().compareTo(a.getValue());
                }
            });
            Collections.reverse(li);
            int[] res = new int[nums.length];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry : li) {
                int key = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    res[idx++] = key;
                }
            }
            
            return res;
        }

    
    
    public static void main(String[] args) {
        SortArrayByIncreasingFrequency obj = new SortArrayByIncreasingFrequency();
        int[] nums = {1,1,2,2,2,3};
        int[] result = obj.frequencySort(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    
}
