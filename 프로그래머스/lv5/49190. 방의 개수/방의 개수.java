import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        Map<Point, Set<Integer>> visited = new HashMap<>();
        
        int[][] delta = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Point cur = new Point(0,0);
        
        visited.put(new Point(cur), new HashSet<>());

        int answer = 0;
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {                
                visited.get(cur).add(arrow<4?arrow+4:arrow-4);
                cur.x += delta[arrow][0];
                cur.y += delta[arrow][1];
                
                Set<Integer> s = visited.get(cur);
                if (s == null) {
                    s = new HashSet<>();
                    s.add(arrow);
                    visited.put(new Point(cur), s);
                } else if (!s.contains(arrow)) {
                    s.add(arrow);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

class Point {
    int x, y;
    
    public Point(int[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Point)) return false;
        
        Point p = (Point) o;
        return this.x==p.x && this.y==p.y;
    }
    
    public int hashCode() {
        return Objects.hash(this.x) + Objects.hash(this.y);
    }
    
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}