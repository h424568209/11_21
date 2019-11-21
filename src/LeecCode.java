import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeecCode {
    public boolean circularArrayLoop(int[] nums) {
        int n  = nums.length;
        if(n==1){
            return false;
        }
        boolean[]visited = new boolean[n];
        for(boolean v : visited){
            v = false;
        }
        int i = 0 ;
        while(i<n){
            int j = i ;
            ArrayList<Integer> list = new ArrayList<>();
            while(true){
                visited[j] = true;
                list.add(j);
                int next= nums[j]+j;
                while(next>=n||next<0){
                    if(next>=n){
                        next%=n;
                    }else{
                        next = next + n ;
                    }
                }
                if(j == next || nums[j] * nums[next] <0){
                    break;
                }
                    if(list.contains(next)){
                        return true;
                    }
                    j = next;
            }
            while(visited[i]){
                i++;
                if(i>=n){
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * 反转字符串数组中的元音字母
     * @param s 字符串
     * @return 反转后的字符串
     * 将元音的字符先都放到顺序表中 ，将字符串转换成数组的形式
     * 在数组中以快速排序的形式检索顺序表中的元素
     * 发现元音字母进行交换
     * 最后返回数组转换形成的字符串
     */
    public String reverseVowels(String s) {
        List<Character> list = new ArrayList<>();
        char [] letters = s.toCharArray();
        char[] letter=new char[] {'a','e','i','o','u','A','E','I','O','U'};
        for(int i = 0 ; i < letter.length ;i++){
            list.add(letter[i]);
        }
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start<s.length() && !list.contains(letters[start])){
                start++;
            }
            while(end>=0 && !list.contains(letters[end])){
                end--;
            }
            if(end > start){
                char t = letters[start];
                letters[start] = letters[end];
                letters[end] = t;
                end--;
                start++;
            }
        }
       s = String.valueOf(letters);
        return s;
    }


    /**
     *  逆序数组中的元素
     * @param s 数组
     *
     */
    public void reverseString(char[] s) {
        int e = s.length-1;
        //使用位运算
        for(int i = 0 ; i < s.length/2 ; i++){
            int j = e-i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
        //使用中间值进行交换
        int end = s.length-1;
        for(int i = 0 ; i < s.length/2 ; i ++){
            swap(s,end,i);
            end--;
        }
    }

    private void swap(char[] s, int end, int i) {
        char t = s[end];
        s[end] = s[i];
        s[i] = t;
    }

    public static void main(String[] args) {
        char s[]= {};
        LeecCode l = new LeecCode();
        l.reverseString(s);
        System.out.println(Arrays.toString(s));
        String s1 = "eeeeu";
       String m =  l.reverseVowels(s1);
        System.out.println(m);
    }
}
