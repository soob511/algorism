import java.util.*;
class Solution {
    public String solution(String s) {
        // char[] c = s.toCharArray();
        // for(int i=0;i<c.length;i++){
        //     if(c[i]<=90){
        //         c[i]+=32;
        //     }
        // }
        // Arrays.sort(c);
        // String answer = String.valueOf(c);
        // return answer;
        
        char[] c = s.toLowerCase().toCharArray();
        Arrays.sort(c);
        String answer = new String(c);
        return answer;
    }
}
