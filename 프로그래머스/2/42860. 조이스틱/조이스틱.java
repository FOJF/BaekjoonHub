class Solution {
    public int solution(String name) {
        int udMove = 0;
        
        for(char c : name.toCharArray()) {
            udMove += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int lrMove = Integer.MAX_VALUE;
        for(int i = 0; i < name.length(); i++) {
            int tmp = Math.min((i + name.length()) % name.length(), (-i + name.length()) % name.length());
             
            int lMove = 0;
            int l = 1;
            int lIdx = (i - l + name.length()) % name.length();
            while(lIdx != i) {
                if (name.charAt(lIdx) != 'A') lMove = l;
                
                l++;
                lIdx = (i - l + name.length()) % name.length();
            }
            
            int rMove = 0;
            int r = 1;
            int rIdx = (i + r + name.length()) % name.length();
            while(rIdx != i) {
                if (name.charAt(rIdx) != 'A') rMove = r;
                
                r++;
                rIdx = (i + r + name.length()) % name.length();
            }
            
            lrMove = Math.min(lrMove, tmp + Math.min(lMove, rMove));
        }
        
        return udMove + lrMove;
    }
}