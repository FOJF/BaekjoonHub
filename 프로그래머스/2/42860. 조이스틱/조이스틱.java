class Solution {
    public int solution(String name) {
        int answer = 0;
        
        for(char c : name.toCharArray()) {
            // 위, 아래 키 계산
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int lrMove = Integer.MAX_VALUE;
        for(int i = 0; i < name.length(); i++) {
            // 좌우는 어캐함?
            // if (name.charAt(i) == 'A') continue;
            // 시작 위치 정하기
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
        
        return answer + lrMove;
    }
}