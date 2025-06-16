import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        
        return answer > hashSet.size() ? hashSet.size() : answer;
    }
}