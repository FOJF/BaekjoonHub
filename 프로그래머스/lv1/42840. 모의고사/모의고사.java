import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[][] supojas = {{ 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }};
        
        int[] cnt = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for (int j = 0; j < cnt.length; j++) {
                if (supojas[j][i%supojas[j].length] == answers[i]) cnt[j]++;
            }
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == max) answer.add(i+1);
        }
        
        return answer;
    }
}