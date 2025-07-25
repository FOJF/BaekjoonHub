import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> sumPlayByGenre = new HashMap<>();
        Map<String, List<Integer[]>> genresWithPlays = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            sumPlayByGenre.put(genres[i], sumPlayByGenre.getOrDefault(genres[i],0)+plays[i]);
            
            genresWithPlays.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Integer[]{i, plays[i]});
        }
        
        List<String> genresSort = new ArrayList<>(sumPlayByGenre.keySet());
        
        genresSort.sort((a,b) -> sumPlayByGenre.get(b) - sumPlayByGenre.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : genresSort) {
            List<Integer[]> p = genresWithPlays.get(genre);
            
            p.sort((a,b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return b[1]-a[1];
            });
            
            answer.add(p.get(0)[0]);
            if (p.size() >= 2) answer.add(p.get(1)[0]);
        }
        
        return answer;
    }
}
