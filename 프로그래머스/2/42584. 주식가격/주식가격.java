import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> idxs = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while(!idxs.isEmpty() && prices[idxs.peekLast()] > prices[i]) {
                int idx = idxs.pollLast();
                answer[idx] = i-idx;
            }
            idxs.addLast(i);
        }
        
        while(!idxs.isEmpty()) {
                int idx = idxs.pollLast();
                answer[idx] = prices.length-idx-1;
        }
        
        return answer;
    }
}