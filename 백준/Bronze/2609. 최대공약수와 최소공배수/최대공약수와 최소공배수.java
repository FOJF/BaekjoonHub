import java.util.Scanner;

public class Main {
    static int Euclidean(int a, int b) { // 유클리드 호제법을 사용해 최대 공약수를 구하는 함수
        if (b == 0)
            return a;
        return Euclidean(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int gcf = Euclidean(Math.max(x,y),Math.min(x,y));

        System.out.println(gcf); // 최대 공약수 출력
        System.out.println(x*y/gcf); // 최소 공배수 출력

        sc.close();
    }
}