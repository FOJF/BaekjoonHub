/*
Cube = 6, Triple = (3,4,5)
Cube = 12, Triple = (6,8,10)
Cube = 18, Triple = (2,12,16)
Cube = 18, Triple = (9,12,15)
Cube = 19, Triple = (3,10,18)
Cube = 20, Triple = (7,14,17)
Cube = 24, Triple = (12,16,20)
*/
public class Main {
    public static void main(String[] args) {
        for (int a = 6; a < 101; a++) {
            for (int i = 2; i < 100; i++) {
                for (int j = i; j < 100; j++) {
                    for (int k = j; k < 100; k++) {
                        if (a*a*a == i*i*i + j*j*j + k*k*k) System.out.println("Cube = " + a + ", Triple = (" + i+","+j+","+k+")");
                    }
                }
            }    
        }
        
    }
}