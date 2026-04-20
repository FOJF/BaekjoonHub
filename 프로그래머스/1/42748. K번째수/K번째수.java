import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] cmds) {
        int[] answer = new int[cmds.length];
        
        for (int i = 0; i < cmds.length; i++) {
            answer[i] = Arrays.stream(arr, cmds[i][0]-1, cmds[i][1]).sorted().skip(cmds[i][2]-1).findFirst().getAsInt();
        }
        
        return answer;
    }
}