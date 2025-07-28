import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Queue<int[]> diskController = new PriorityQueue<>(Comparator.comparingInt((int[] job) -> job[2])
                                                          .thenComparingInt(job -> job[1])
                                                          .thenComparingInt(job -> job[0]));
        
        List<int[]> jobList = new ArrayList<>();
        
        for(int i = 0; i < jobs.length; i++) {
            jobList.add(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        
        jobList.sort(Comparator.comparingInt((int[] job) -> job[1]));
        
        int answer = 0;
        
        int nowJobEndTime = 0;
        int[] nowJob = null;
        int idx = 0;
        
        int totalTime = Arrays.stream(jobs).mapToInt(job -> job[1]).sum();
        
        for(int time = 0; time < totalTime; time++) {
            // while(idx < jobs.length && jobs[idx][0] <= time) {
            //     diskController.add(new int[]{idx, jobs[idx][0], jobs[idx][1]});
            //     idx++;
            // }
            
            while(idx < jobList.size() && jobList.get(idx)[1] <= time) {
                diskController.add(jobList.get(idx++));
            }
            
            if (!diskController.isEmpty() && time >= nowJobEndTime && diskController.peek()[1] <= time) {
                nowJob = diskController.poll();
                nowJobEndTime =  nowJob[2] + time;
                answer += nowJob[2] + time - nowJob[1];
                System.out.println("nowJobEndTime : " + nowJobEndTime + ", answer : " + answer);
            }
        }
        return answer/jobs.length;
    }
}