import java.io.*;
import java.util.TreeSet;

public class Main {
    static TreeSet<Integer> strArrToIntTreeSet(String[] strArray) {
        TreeSet<Integer> intTS = new TreeSet<>();
        for (String s : strArray) {
            intTS.add(Integer.parseInt(s));
        }
        return intTS;
    }

    static int[] strArrToIntArr(String[] strArray) {
        int[] intArr = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArr[i] = Integer.parseInt(strArray[i]);
        }
        return intArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine(); // N
        String[] a = br.readLine().split(" ");
        br.readLine(); // M
        String[] b = br.readLine().split(" ");
        br.close();

        TreeSet<Integer> aSet = strArrToIntTreeSet(a);
        int[] bArr = strArrToIntArr(b);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < bArr.length; i++) {
            if (aSet.contains(bArr[i])) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }
}