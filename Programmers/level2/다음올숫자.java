import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n) {
//             int answer = 0;
//             String binary = Integer.toBinaryString(n);
//             int count = 0;
//             for(int i=0;i<binary.length();i++){
//                  if(binary.charAt(i)=='1'){
//                         count++;
//                     }
//                 }
        
//                 System.out.println(binary);
        
//             for(int i=n+1;i<1000000;i++){
//                 int cnt = 0;
//                 String binarys = Integer.toBinaryString(i);
//                  for(int j=0;j<binarys.length();j++){
//                         if(binarys.charAt(j)=='1'){
//                              cnt++;
//                         }
//                     }
//                  if(count==cnt){
//                      answer= i;
//                         break;
//                     }
//             }
        int answer = 0;
        int n_cnt = Integer.bitCount(n);
        int count = 0;
        while(true){
            n++;
            count = Integer.bitCount(n);
            if(n_cnt==count){
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}