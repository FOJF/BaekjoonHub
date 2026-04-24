import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        for(int n : numbers) {
            nums.add(n);
        }
        
        nums.sort((a, b) -> {
            int bb = Integer.parseInt(b + "" + a);
            int aa = Integer.parseInt(a + "" + b);
            
            return bb - aa;
        });
        
        if (nums.get(0) == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int n : nums) {
            sb.append(n);
        }
        return sb.toString();
    }
}