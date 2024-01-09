import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(stack.isEmpty()){
                stack.push(c[i]);
            }else if(stack.peek()==c[i]){
                stack.pop();
            }else{
                stack.push(c[i]);
            }
        }
        if(stack.size()>0){
            return 0;
        }
        return answer;
    }
}
