import java.util.*;

class Solution {
    public int solution(String message, int[][] blurRanges) {
        String[] words = message.split(" ");
        
        Set<String> normal = new HashSet<>();
        List<String> blur = new ArrayList<>();
        
        int offset = 0;
        int blurIdx = 0;
        
        for(String word : words) {
            int start = offset;
            int end = offset + (word.length()-1);
            
            while (blurIdx < blurRanges.length && blurRanges[blurIdx][1] < start) {
                blurIdx++;
            }
            
            if (blurIdx < blurRanges.length && blurRanges[blurIdx][0] <= end) {
                blur.add(word);
            } else {
                normal.add(word);
            }
            
            offset += word.length()+1;
        }
        
        Set<String> important = new HashSet<>();
        for(String b : blur) {
            if (normal.contains(b)) continue;
            
            important.add(b);
        }
        
        return important.size();
    }
}