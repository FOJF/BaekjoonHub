import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int countPrimeNumber = 0;

        for (int i = 0; i < n; i++) {
            int testNumber = sc.nextInt();
            int checkPrime = 0;
            for (int j = 2; j < (int)(Math.sqrt(testNumber)+1); j++) {
                if(testNumber % j == 0) {
                    checkPrime++;
                    break;
                }
            }
            if (checkPrime == 0) countPrimeNumber++;
            if(testNumber == 1) countPrimeNumber--;
        }
        System.out.println(countPrimeNumber);
    }
}