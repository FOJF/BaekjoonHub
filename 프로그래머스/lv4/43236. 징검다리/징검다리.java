import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int min = 0;
        int max = distance;
        int answer = 0;
        
        while(min <= max) {
            int rockCnt = 0;
            int before = 0;
            
            int mid = (min+max)/2;
            
            for(int rock : rocks) {
                if (rockCnt == rocks.length-n) break;
                
                if (rock-before >= mid) {
                    rockCnt++;
                    before = rock;
                }
            }
            
            if (distance-before < mid || rockCnt < rocks.length-n) {
                max = mid-1;
            } else {
                min = mid+1;
                answer = mid;
            }
        }
        
        return answer;
    }
}
//0 2 11 14 17 21 25
// 2 9  3  3  4  4