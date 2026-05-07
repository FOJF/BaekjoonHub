class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0;
        
        for(int t : times) {
            max = Math.max(t, max);
        }
        max *= n;
        
        long min = 0;
        
        while(min <= max) {
            long mid = (min+max)/2;
            
            long immied = 0;
            
            for(int t : times) {
                immied += mid/t;
            }
            
            if (immied >= n) {
                max = mid-1;
                answer = mid;
            } else {
                min = mid+1;
            }
        }
        
        return answer;
    }
}