package soo.joe.demo.algorithm.leetcode;

/**
 * @author: suzhou
 * @createtime: 2019-03-28  15:34
 * @description:
 */
public class Atoi {
    public static int myAtoi(String str) {
        boolean isPositive=true;
        int result=0;
        int i=0;
        while(str.startsWith(" ")){
            str=str.substring(1,str.length());
        }
        if(str==null||str.length()==0){
            return 0;
        }
        if(str.charAt(0)=='-'){
            isPositive=false;
            i=1;
        }
        if(str.charAt(0)=='+'){
            i=1;
        }
        for(;i<str.length();i++){
            if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
                int cInt=str.charAt(i)-'0';
                if(isPositive){
                    if(result>(Integer.MAX_VALUE-cInt)/10){
                        return Integer.MAX_VALUE;
                    }
                }else {
                    if(cInt>0){cInt--;}
                    if(result>(Integer.MAX_VALUE-cInt)/10){
                        return Integer.MIN_VALUE;
                    }
                }
                result=result*10+(str.charAt(i)-'0');
            }else {
                break;
            }
        }
        result=isPositive==true?result:-result;
        return result;
    }

    public static void main(String[] args) {
        // max=2147483647
//        System.out.println(Integer.MAX_VALUE);
//        // min=-2147483648
//        System.out.println(Integer.MIN_VALUE);

        System.out.println(myAtoi("  -4 5"));
    }
}
