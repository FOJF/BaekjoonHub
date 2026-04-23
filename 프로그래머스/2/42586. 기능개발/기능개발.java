import java.util.*;

class Solution {
    public List<Integer> solution(int[] p, int[] s) {
        for(int i = 0; i < p.length; i++) {
            int o = (100-p[i])%s[i] > 0 ? 1 : 0;
            p[i] = (100-p[i]) / s[i] + o;
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int a = 1;
        int d = p[0];
        for(int i = 1; i < p.length; i++) {
            if (p[i] > d) {
                answer.add(a);
                a = 1;
                d = p[i];
            } else {
                a++;
            }
        }
        answer.add(a);
        return answer;
    }
}