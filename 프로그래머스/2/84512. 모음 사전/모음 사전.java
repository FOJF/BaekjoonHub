class Solution {
    public int solution(String word) {
        char[] mo = {'A', 'E', 'I', 'O', 'U'};
        
        int[] c = {0, 0, 0, 0, 0};
        
        int answer = 1;
        int idx = 0;

        while(true) {
            if (idx+1 == word.length()) {
                boolean equal = true;
                for(int i = 0; i <= idx; i++) {
                    if (mo[c[i]] != word.charAt(i)) {
                        equal = false;
                        break;
                    }
                }
                if (equal) return answer;
            }

            answer++;
            
            if (idx < c.length-1) {
                idx++;
            } else {
                c[idx] = (c[idx]+1)%mo.length;
                while(c[idx] == 0) {
                    idx = Math.max(0, idx-1);
                    c[idx] = (c[idx]+1)%mo.length;
                }
            }
        }
    }
}