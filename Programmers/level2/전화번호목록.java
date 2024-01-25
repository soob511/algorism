import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hash = new HashSet<>();
        for(int i=0;i<phone_book.length;i++){
            hash.add(phone_book[i]);
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(hash.contains(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}
