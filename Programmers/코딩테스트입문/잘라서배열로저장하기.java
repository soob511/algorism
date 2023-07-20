import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int num = 0;
       if(my_str.length()%n==0){
           num = my_str.length()/n;
        }else{
           num = (my_str.length()/n)+1;
       }
       String[] answer = new String[num];
        for(int i=0;i<num;i++){
            int start = n*i;
            int end=0;
            if(start+n >= my_str.length()){
                end = my_str.length();
            }else{
                end = start+n;
            }
            answer[i] = my_str.substring(start,end);
        }
        
        
        return answer;
    }
}
