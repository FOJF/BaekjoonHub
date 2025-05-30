import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pitch = sc.nextLine().replaceAll(" ","");

        if(pitch.equals("12345678")) System.out.println("ascending");
        else if(pitch.equals("87654321")) System.out.println("descending");
        else System.out.println("mixed");
    }
}