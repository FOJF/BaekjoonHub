import java.util.*;

class Solution {
    private Map<Integer, Map<Integer,Integer>> fares;
    private int verticesCnt;
    
    public int solution(int n, int s, int a, int b, int[][] f) {
        fares = new HashMap<>();
        verticesCnt = n;
        
        for (int[] fare : f) {
            addFare(fare);
        }
        
        int[] togetherFares = setFaresFrom(s);
        int[] faresFromA = setFaresFrom(a);
        int[] faresFromB = setFaresFrom(b);
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            if (togetherFares[i] == Integer.MAX_VALUE) continue;
            min = Math.min(min, togetherFares[i] + faresFromA[i] + faresFromB[i]);
            // if (min == 18) System.out.println(togetherFares[i] + " " + faresFromI[a] + " " + faresFromI[b]);
        }
        
        return min;
    }
    
    public void addFare(int[] fare) {
        Map<Integer,Integer> fares0 = fares.getOrDefault(fare[0], new HashMap<>());
        Map<Integer,Integer> fares1 = fares.getOrDefault(fare[1], new HashMap<>());
        
        fares0.put(fare[1], fare[2]);
        fares1.put(fare[0], fare[2]);
        
        fares.put(fare[0], fares0);
        fares.put(fare[1], fares1);
    }
    
    public int[] setFaresFrom(int from) {
        Queue<int[]> bfsQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        boolean[] visited = new boolean[verticesCnt+1];
        int[] tmpFares = new int [verticesCnt+1];
        Arrays.fill(tmpFares, Integer.MAX_VALUE);
        
        bfsQ.add(new int[]{from, 0});
        tmpFares[from] = 0;
        
        while(!bfsQ.isEmpty()) {
            int[] now = bfsQ.poll();
            
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            
            Map<Integer, Integer> linkedNow = fares.get(now[0]);
            
            if (linkedNow == null) continue;
            
            for (int next : linkedNow.keySet()) {
                
                int expectedNextFare = tmpFares[now[0]] + linkedNow.get(next);
            
                if (tmpFares[next] > expectedNextFare) {
                    bfsQ.add(new int[]{next, expectedNextFare});
                    tmpFares[next] = expectedNextFare;
                }
            }
        }
        
        return tmpFares;
    }
}