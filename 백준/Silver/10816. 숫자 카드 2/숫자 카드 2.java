import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        HashMap<Integer, Integer> deck = StrToIntHashMap(br.readLine());
        br.readLine();
        int[] numbers = StrToIntArr(br.readLine());

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int number : numbers) {
            Integer hasNumber = deck.get(number);
            if (hasNumber == null) hasNumber = 0;
            bw.write(hasNumber + " ");
        }
        bw.flush();
        bw.close();
    }

    static HashMap<Integer, Integer> StrToIntHashMap(String s) {
        String[] sSplit = s.split(" ");
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (String a : sSplit) {
            int key = Integer.parseInt(a);
            Integer value = integerHashMap.get(key);
            value = (value == null) ? 1 : (value + 1);
            integerHashMap.put(key, value);
        }
        return integerHashMap;
    }

    static int[] StrToIntArr(String s) {
        String[] sSplit = s.split(" ");
        int[] intArr = new int[sSplit.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(sSplit[i]);
        }
        return intArr;
    }
}