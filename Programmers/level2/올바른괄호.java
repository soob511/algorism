import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                stack.push(c[i]);
            }else{
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }
                if(!stack.isEmpty()&&stack.pop()!='('){
                    answer = false;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}
