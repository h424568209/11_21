import java.util.Scanner;

public class Main_11_21_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println((n|m)+(m&n));
        }
    }
}
