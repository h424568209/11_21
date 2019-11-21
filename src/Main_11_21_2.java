import java.util.Scanner;

public class Main_11_21_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int x = scanner.nextInt();
            int count = 0;
            while(x!=0 && count<=30_0000){
                x = ((x<<1)+1)%1_000_000_007;
                count++;
            }
            int res = (count+2)/3;
            System.out.println(res>10_0000?-1:res);
        }
    }
}
