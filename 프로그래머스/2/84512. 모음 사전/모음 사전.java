class Solution {
    public int solution(String word) {
        char[] mo = {'A', 'E', 'I', 'O', 'U'};
        
        int[] c = {0, 0, 0, 0, 0};
        
        int answer = 1;
        int idx = 0;

        while(true) {
            if (idx+1 == word.length() && isMatch(mo, c, word, idx)) return answer;

            answer++;
            
            if (idx < c.length-1) {
                idx++;
            } else {
                while (idx >= 0) {
                    c[idx] = (c[idx] + 1) % mo.length;

                    if (c[idx] != 0) break;
                    
                    idx--;
                }
            }
        }
    }
    
    private boolean isMatch(char[] mo, int[] c, String word, int idx) {
        for (int i = 0; i <= idx; i++) {
            if (mo[c[i]] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}