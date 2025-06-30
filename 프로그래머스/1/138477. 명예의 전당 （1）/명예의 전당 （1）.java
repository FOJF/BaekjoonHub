import java.util.*;

class Solution {
    public List<Integer> solution(int k, int[] score) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (i < k) answer.add(pq.peek());
            else {
                pq.poll();
                answer.add(pq.peek());
            }
        }
        
        return answer;
    }
}