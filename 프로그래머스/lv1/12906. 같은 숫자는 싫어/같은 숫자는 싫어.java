import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        int lastNum = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (lastNum == arr[i]) continue;
            
            lastNum = arr[i];
            answer.add(arr[i]);
        }

        return answer;
    }
}