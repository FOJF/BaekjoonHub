import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int min = 0;
        int max = citations[citations.length-1];
        int answer = 0;
        
        while(min <= max) {
            int mid = (min+max)/2;
            int cnt = 0;
            for(int c : citations) {
                if (c >= mid) break;
                
                cnt++;
            }
            
            if (citations.length-cnt >= mid) {
                answer = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
    
        return answer;
    }
}