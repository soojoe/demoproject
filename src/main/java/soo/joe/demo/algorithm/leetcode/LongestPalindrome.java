package soo.joe.demo.algorithm.leetcode;

/**
 * @author: suzhou
 * @createtime: 2019-03-27  15:33
 * @description: 最长回文
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String tt=s.replaceAll(s.charAt(0)+"","");
        if(tt.equals("")){return s;}
        int max=0;
        String longestPalindrome="";
        String tmp=fillChar(s);
        for(int i=1;i<tmp.length()-1;i++){
            String longS=getLongS(i,tmp);
            if(longS.length()>max){
                max=longS.length();
                longestPalindrome=longS;
            }
        }
        return longestPalindrome.replaceAll("#","");
    }

    private static String getLongS(int center, String s) {
        String result=s.charAt(center)+"";
        for(int left=center-1,right=center+1;left>=0&&right<s.length();left--,right++){
            if(s.charAt(left)==s.charAt(right)){
                result=s.charAt(left)+result+s.charAt(right);
            }else {
                break;
            }
        }
        return result;
    }

    private static String fillChar(String s){
        StringBuffer buffer=new StringBuffer("#");
        for(int i=0;i<s.length();i++){
            buffer.append(s.charAt(i)+"#");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("dddddddddddddddddddddddddddddddddddddddddddddddddd"));
    }
}
