import java.util.*;
class Solution {
    public int[] solution(String s) {
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=0;i<s.length();i++){
//             int c = s.charAt(i);
//             if(c>=48&&c<=57){
//                 list.add((int)c-48);
//             }
//         }
//          int[] answer = new int[list.size()];
//         for(int i=0;i<list.size();i++){
//             answer[i] = list.get(i);
//         }
//         Arrays.sort(answer);
//         return answer;
        
          s=s.replaceAll("[a-z]","");
          int[] answer = new int[s.length()];
          for(int i=0;i<s.length();i++){
              answer[i] = s.charAt(i) - 48;
          }
          Arrays.sort(answer);
          return answer;
    }
}
