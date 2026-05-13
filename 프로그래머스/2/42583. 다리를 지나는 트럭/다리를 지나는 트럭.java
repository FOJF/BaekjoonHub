import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        
        Queue<Integer> q = new ArrayDeque<>(bridgeLength);
        
        for(int i = 0; i < bridgeLength; i++) {
            q.add(-1);
        }
        
        int answer = 0;
        int idx = 0;
        
        int nowBridgeWeight = 0;
        int nowBridgeCnt = 0;
        
        int passedCnt = 0;
        
        while(passedCnt < truckWeights.length) {
            int passed = q.poll();
            if(passed >= 0) {
                passedCnt++;
                nowBridgeCnt--;
                nowBridgeWeight -= truckWeights[passed];
            }
            
            answer++;
            
            if (idx < truckWeights.length) {
                int next = truckWeights[idx];

                if(next+nowBridgeWeight > weight) {
                    q.add(-1);
                } else {
                    q.add(idx);
                    nowBridgeCnt++;
                    nowBridgeWeight += truckWeights[idx++];
                }
            }
        }
        
        return answer;
    }
}