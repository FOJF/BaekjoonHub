import java.util.*;

class Solution {
    public List<String> solution(String[][] tickets) {
        Map<String, List<String>> ticketMap = new HashMap<>();
        
        for(String[] ticket : tickets) {
            List<String> toList = ticketMap.computeIfAbsent(ticket[0], k -> new LinkedList<>());
            toList.add(ticket[1]);
        }
        
        for(List<String> toList : ticketMap.values()) {
            toList.sort((a, b) -> a.compareTo(b));
        }
        List<String> answer = new ArrayList<>();
        dfs("ICN", tickets.length, ticketMap, answer);
        return answer;
    }
    
    List<String> visited = new ArrayList<>();
    private void dfs(String from, int ticketCnt, Map<String, List<String>> ticketMap, List<String> answer) {
        if (!answer.isEmpty()) return;
        if (visited.size() == ticketCnt) {
            answer.add("ICN");
            for(String v : visited) {
                answer.add(v);
            }
            return;
        }
        
        List<String> toList = ticketMap.getOrDefault(from, new ArrayList<>());
        
        for(int i = 0; i < toList.size(); i++) {
            String to = toList.get(i);
            toList.remove(i);
            visited.add(to);
            dfs(to, ticketCnt, ticketMap, answer);
            visited.remove(visited.size()-1);
            toList.add(i, to);
        }
    }
}