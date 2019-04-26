package soo.joe.demo.algorithm.leetcode;

/**
 * @author: suzhou
 * @createtime: 2019-03-27  16:39
 * @description: 数据反转
 */
public class Reverse {
    public static int reverse(int num){
        Boolean f=false;
        if(num<0){
            num=-num;
            f=true;
        }
        int result=0;
        while (num>0){
            if((Integer.MAX_VALUE-num%10)/10<result){
                return 0;
            }
            result=result*10+num%10;
            num=num/10;
            if(result<0){return 0;}
        }
        result=f==true?-result:result;
        return result;
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        int result=0;
        int num=x;
        while (num>0){
            result=result*10+num%10;
            num=num/10;
        }
        if(x==result){return true;}else {return false;}
    }

    public static void main(String[] args) {
        int num=1534236469;
        int r=964632435*10;
        r=r+1;
        System.out.println(isPalindrome(121));
    }
}
