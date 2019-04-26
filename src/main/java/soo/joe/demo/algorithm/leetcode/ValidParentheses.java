package soo.joe.demo.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: suzhou
 * @createtime: 2019-03-28  15:01
 * @description: 验证括号
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        Stack stack1=new Stack();
        Stack stack2=new Stack();
        String left="([{";
        String right=")]}";
        for(int i=0;i<s.length();i++){
            stack1.push(s.charAt(i));
        }
        while (!stack1.empty()){
            char c=(char)stack1.pop();
            stack2.push(c);
            while (!stack1.empty()&&!stack2.empty()&&
                    left.indexOf((char)stack1.peek())==right.indexOf((char)stack2.peek())&&
                    left.indexOf((char)stack1.peek())!=-1){
                stack1.pop();
                stack2.pop();
            }
        }
        if(stack2.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO: 2019/3/28
        System.out.println(isValid("{}[]}"));
    }
}
