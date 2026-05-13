import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, int[]> bests = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            int[] best = bests.computeIfAbsent(genres[i], k -> new int[]{0,-1,-1});
            best[0] += plays[i];
            
            if (best[1] == -1 || plays[i] > plays[best[1]]) {
                best[2] = best[1];
                best[1] = i;
            } else if (best[2] == -1 || plays[i] > plays[best[2]]) {
                best[2] = i;
            }
        }
        
        List<int[]> tmp = new ArrayList<>(bests.values());
        tmp.sort((a, b) -> b[0]-a[0]);
        
        List<Integer> answer = new ArrayList<>();
        
        for(int[] t : tmp) {
            answer.add(t[1]);
            if (t[2] != -1) answer.add(t[2]);
        }
        
        return answer;
    }
}