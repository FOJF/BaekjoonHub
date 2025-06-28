import java.io.*;

public class Main {
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
            bufferPointer = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        
        int[] max = {fr.nextInt(), fr.nextInt(), fr.nextInt()};
        int[] min = max.clone();
        int[] nextMax = new int[3];
        int[] nextMin = new int[3];
        
        for (int i = 1; i < n; i++) {
            int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
            
            nextMax[0] = a + Math.max(max[0], max[1]);
            nextMax[1] = b + Math.max(Math.max(max[0], max[1]), max[2]);
            nextMax[2] = c + Math.max(max[1], max[2]);
            
            nextMin[0] = a + Math.min(min[0], min[1]);
            nextMin[1] = b + Math.min(Math.min(min[0], min[1]), min[2]);
            nextMin[2] = c + Math.min(min[1], min[2]);
            
            // 배열 참조 교체 (객체 생성 없음)
            int[] tempMax = max;
            max = nextMax;
            nextMax = tempMax;
            
            int[] tempMin = min;
            min = nextMin;
            nextMin = tempMin;
        }
        
        int maxResult = Math.max(max[0], Math.max(max[1], max[2]));
        int minResult = Math.min(min[0], Math.min(min[1], min[2]));
        System.out.println(maxResult + " " + minResult);
    }
}
