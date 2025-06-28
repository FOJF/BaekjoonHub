import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // DP 상태 배열 (고정 크기 4개 배열로 전체 처리)
        int[] max = new int[3];
        int[] min = new int[3];
        int[] nextMax = new int[3];
        int[] nextMin = new int[3];
        
        // 첫 번째 줄 파싱 및 초기화
        parseLine(br.readLine(), max);
        System.arraycopy(max, 0, min, 0, 3);
        
        // 두 번째 줄부터 처리
        for (int i = 1; i < n; i++) {
            int[] input = new int[3];
            parseLine(br.readLine(), input);
            
            // 최대값 계산
            nextMax[0] = input[0] + Math.max(max[0], max[1]);
            nextMax[1] = input[1] + Math.max(max[0], Math.max(max[1], max[2]));
            nextMax[2] = input[2] + Math.max(max[1], max[2]);
            
            // 최소값 계산
            nextMin[0] = input[0] + Math.min(min[0], min[1]);
            nextMin[1] = input[1] + Math.min(min[0], Math.min(min[1], min[2]));
            nextMin[2] = input[2] + Math.min(min[1], min[2]);
            
            // 배열 참조 교체 (새 객체 생성 없이 상태 업데이트)
            int[] tempMax = max;
            int[] tempMin = min;
            max = nextMax;
            min = nextMin;
            nextMax = tempMax;
            nextMin = tempMin;
        }
        
        // 결과 계산 및 출력
        int maxResult = Math.max(max[0], Math.max(max[1], max[2]));
        int minResult = Math.min(min[0], Math.min(min[1], min[2]));
        System.out.println(maxResult + " " + minResult);
    }
    
    // 문자열 분리 없이 직접 파싱 (메모리 효율화)
    private static void parseLine(String line, int[] arr) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            int num = 0;
            while (index < line.length() && line.charAt(index) != ' ') {
                num = num * 10 + (line.charAt(index++) - '0');
            }
            arr[i] = num;
            index++; // 공백 건너뛰기
        }
    }
}