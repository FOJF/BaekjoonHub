import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0;
        
        int[] servers = new int[24];    
    
        for (int i = 0; i < players.length; i++) {
            if (players[i] >= (servers[i]+1)*m) { // players[i] : 현재 유저 수, (servers[i]+1)*m : 현재 서버가 감당할 수 있는 유저 수
                System.out.println(i + " " + (players[i] / ((servers[i]+1)*m)));
                
                int amount = (players[i] - (servers[i]+1)*m) / m + 1;
                
                addServers(servers, i, k, amount);
                answer += amount;
            }
        }
        
        System.out.println(Arrays.toString(servers));
        
        return answer;
    }
    
    public void addServers(int[] servers, int time, int k, int amount) {
        int to = Math.min(24, time + k);
        for (int i = time; i < to; i++) {
            servers[i] += amount;
        }
    }
}

