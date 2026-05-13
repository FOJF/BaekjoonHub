import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        
        Queue<Integer> bridge = new ArrayDeque<>(bridgeLength);
        
        for(int i = 0; i < bridgeLength; i++) {
            bridge.add(-1);
        }
        
        int answer = 0;
        int idx = 0;
        
        int nowBridgeWeight = 0;
        
        int passedCnt = 0;
        
        while(passedCnt < truckWeights.length) {
            int passed = bridge.poll();
            
            if(passed >= 0) {
                passedCnt++;
                nowBridgeWeight -= truckWeights[passed];
            }
            
            answer++;
            
            if (idx < truckWeights.length) {
                int next = truckWeights[idx];

                if(next+nowBridgeWeight > weight) {
                    bridge.add(-1);
                } else {
                    bridge.add(idx);
                    nowBridgeWeight += truckWeights[idx++];
                }
            }
        }
        
        return answer;
    }
}