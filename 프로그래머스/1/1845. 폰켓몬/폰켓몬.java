import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        
        int answer = Math.min(hashSet.size(), nums.length/2);
        
        return answer;
    }
}