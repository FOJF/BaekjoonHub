import java.util.*;

enum Info {LEN, OP_START, OP_END}

class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int[] video_infos = {parseToInt(video_len), parseToInt(op_start), parseToInt(op_end)};
        String answer = opening(pos, video_infos);
    
        for(String cmd : commands) {
            answer = calculateVideoTime(cmd, answer, video_infos);
            answer = opening(answer, video_infos);
        }
        
        return answer;
    }
    
    public String calculateVideoTime(String cmd, String pos, int[] video_infos) {
        int time = parseToInt(pos);
        int video_len = video_infos[Info.LEN.ordinal()];
        int opStart = video_infos[Info.OP_START.ordinal()];
        int opEnd = video_infos[Info.OP_END.ordinal()];
        
        if(cmd.charAt(0) == 'p') {
            time = Math.max(time-10, 0);
        } else {
            time = Math.min(time+10, video_len);
        }
        
        return parseToString(time);
    }
    
    public String opening(String pos, int[] video_infos) {
        int time = parseToInt(pos);
        int opStart = video_infos[Info.OP_START.ordinal()];
        int opEnd = video_infos[Info.OP_END.ordinal()];
        
        if(time >= opStart)
            time = Math.max(time, opEnd);
        
        return parseToString(time);
    }
    
    public String parseToString (int sec) {
        int m = sec/60;
        int s = sec%60;
        StringBuilder sb = new StringBuilder();
        
        if(m/10 == 0) sb.append('0').append(m);
        else sb.append(m);
        
        sb.append(':');
        
        if(s/10 == 0) sb.append('0').append(s);
        else sb.append(s);
        
        return sb.toString();
    }
    
    public int parseToInt (String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
    }
}