class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) return 0;
        
        int answer = 1;
        // StringBuilder sb = new StringBuilder(B);
        while(answer < A.length()){
            StringBuilder sb = new StringBuilder(A.substring(A.length()-answer));
            sb.append(A.substring(0, A.length()-answer));
            System.out.println(sb);
            if(B.equals(sb.toString()))
                break;
            
            answer++;
        }
        
        return (answer == A.length()) ? -1 : answer;
    }
}