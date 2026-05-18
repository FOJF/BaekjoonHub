import java.util.*;

class Solution {
    public int solution(String message, int[][] blurRanges) {
        String[] words = message.split(" ");
        
        Set<String> normal = new HashSet<>();
        List<String> blur = new ArrayList<>();
        
        int offset = 0;
        int i = 0;
        
        for(String word : words) {
            int start = offset;
            int end = offset + (word.length()-1);
            
            boolean isBlur = false;
            for (; i < blurRanges.length; i++) {
                if (blurRanges[i][0] > end) break;
                
                if (start <= blurRanges[i][1] && end >= blurRanges[i][0]) {
                    isBlur = true;
                    break;
                }
            }
            
            if (isBlur) {
                blur.add(word);
            } else {
                normal.add(word);
            }
            
            offset += word.length()+1;
        }
        
        // System.out.println(normal);
        // System.out.println(blur);
        
        Set<String> important = new HashSet<>();
        for(String b : blur) {
            if (normal.contains(b) || important.contains(b)) continue;
            
            important.add(b);
        }
        
        return important.size();
    }
}