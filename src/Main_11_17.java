import java.util.Arrays;
import java.util.Scanner;

public class Main_11_17 {
    //输出一个n位数的格雷码 1的格雷码是 “0” “1” ，2 的格雷码是“00”，“01”，“10”，“11”
    //通过递归进行求解
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Arrays.toString(getGary(n)));
    }

    private static String[] getGary(int n) {
        String []resStrs = null;
        // 当n 为1 的格雷码
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }else{
            //  下一位数的格雷码位数是上一位的2倍
            //  是 0 和 1 在其开头
            //创建一个2倍其长度的数组进行存储当前的数字的格雷码
            String [] res = getGary(n-1);
            resStrs = new String[2*res.length];
            for(int i = 0 ; i < res.length ; i++){
                resStrs[i] = "0" + res[i];
                resStrs[resStrs.length-i - 1] = "1" + res[i];
            }
        }
        return resStrs;
    }
}
