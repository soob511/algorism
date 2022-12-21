import java.util.*;
class Solution {
    public int solution(String before, String after) {
  
        char[] bc = before.toCharArray();
        char[] ac = after.toCharArray();
        
        Arrays.sort(bc);
        Arrays.sort(ac);
        
        String bs = new String(bc);
        String as = new String(ac);
        
        if(as.equals(bs)){
            return 1;
        }else{
            return 0;
        }

       
    }
}
