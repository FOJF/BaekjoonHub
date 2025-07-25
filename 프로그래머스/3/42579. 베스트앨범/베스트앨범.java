import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer[]> playDistinct = new ArrayList<>();
        Map<String, Integer> sumPlayByGenre = new HashMap<>();
        
        Map<String, List<Integer[]>> gp = new HashMap<>();
        
        // int playDistinctIdx = 0;
        
        for(int i = 0; i < genres.length; i++) {
//             if (genreIdx.get(genres[i]) == null)
//                 genreDistinct.put(genres[i], playDistinctIdx++);
            
//             int playDistinctIdx = genreIdx.get(genres[i]);
//             if (playDistinct.size() == playDistinctIdx) playDistinct.add(plays[i]);
//             else playDistinct.get(playDistinctIdx) += plays[i];
            
            
            
            sumPlayByGenre.put(genres[i], sumPlayByGenre.getOrDefault(genres[i],0)+plays[i]);
            
            
            gp.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Integer[]{i, plays[i]});
        }
        

        
        // System.out.println(total);
        // System.out.println(gp);
        
        List<String> genresSort = new ArrayList<>(sumPlayByGenre.keySet());
        
        genresSort.sort((a,b) -> sumPlayByGenre.get(b) - sumPlayByGenre.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : genresSort) {
            List<Integer[]> m = gp.get(genre);
            
            m.sort((a,b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return b[1]-a[1];
            });
            
            answer.add(m.get(0)[0]);
            if (m.size() >= 2) answer.add(m.get(1)[0]);
        }
        
        return answer;
    }
}