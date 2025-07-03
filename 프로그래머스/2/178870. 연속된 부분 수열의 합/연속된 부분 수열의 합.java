import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
           if ((o1[1] - o1[0]) == (o2[1] - o2[0])) return o1[0] - o2[0];
            
            return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        });
        
        while(start<=end) {
            if (sum > k) {
                sum -= sequence[start];
                if (start == sequence.length-1) break;
                start++;
            } else if (sum == k) {
                pq.add(new int[]{start, end});
                if (end == sequence.length-1) break;
                end++;
                sum += sequence[end];
            } else {
                if (end == sequence.length-1) break;
                end++;
                sum += sequence[end];
            }
        }
        // int[] answer = {};
        return pq.poll();
    }
}