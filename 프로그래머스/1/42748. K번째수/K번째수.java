import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0]-1;
            int endIdx = commands[i][1];
            int targetIdx = commands[i][2]-1;
            
            int[] temp = Arrays.copyOfRange(array, startIdx, endIdx);
            
            Arrays.sort(temp);            
            answer[i] = temp[targetIdx];
        }
        
        return answer;
    }
}