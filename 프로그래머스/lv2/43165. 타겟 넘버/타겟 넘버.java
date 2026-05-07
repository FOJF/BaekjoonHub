import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.add(new int[]{numbers[0], 0});
        bfsQ.add(new int[]{-numbers[0], 0});
        
        int answer = 0;
        
        while(!bfsQ.isEmpty()) {
            int[] cur = bfsQ.poll();
            
            if (cur[1] == numbers.length-1 && cur[0] == target) answer++;
            
            if (cur[1] < numbers.length-1) {
                bfsQ.add(new int[]{cur[0]+numbers[cur[1]+1], cur[1]+1});
                bfsQ.add(new int[]{cur[0]-numbers[cur[1]+1], cur[1]+1});
            }
        }
        
        return answer;
    }
}