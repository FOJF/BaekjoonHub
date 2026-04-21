import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] s = new int[n+2];
        
        Arrays.fill(s, 1);
        
        for(int i = 0; i < reserve.length; i++) {
            s[reserve[i]] = 2;
        }
        
        s[0] = 0;
        s[s.length-1] = 0;
        for(int i = 0; i < lost.length; i++) {
            s[lost[i]] -= 1;
        }
        
        System.out.println(Arrays.toString(s));
        
        Arrays.sort(lost);
        
        for(int i = 0; i < lost.length; i++) {
            if (s[lost[i]-1] == 2) {
                s[lost[i]-1] = 1;
                s[lost[i]] = 1;
            } else if (s[lost[i]+1] == 2) {
                s[lost[i]+1] = 1;
                s[lost[i]] = 1;
            }
        }
        System.out.println(Arrays.toString(s));
        
        int answer = 0;
        return (int)Arrays.stream(s).filter(i -> i > 0).count();
    }
}