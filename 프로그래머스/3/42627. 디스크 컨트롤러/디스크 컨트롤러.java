import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (jobs[a][1] != jobs[b][1]) return jobs[a][1] - jobs[b][1];
            if (jobs[a][0] != jobs[b][0]) return jobs[a][0] - jobs[b][0];
            return a - b;
        });
        
        int answer = 0;
        int t = 0;
        int i = 0;
        
        int done = 0;
        
        while(done < jobs.length) {
            while(i < jobs.length && jobs[i][0] <= t) {
                pq.add(i++);
            }
            
            if (pq.isEmpty()) {
                t = jobs[i][0];
            } else {
                int n = pq.poll();
                answer += t + jobs[n][1] - jobs[n][0];
                t += jobs[n][1];
                done++;
            }
            
        }
        
        return answer/jobs.length;
    }
}