import java.util.*;
class Solution {
    static LinkedList<String> list ;
     static char[] c = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        list = new LinkedList<>();
        dfs("",0);
        int size = list.size();
        for(int i=0;i<size;i++){
            if(list.get(i).equals(word)){
                answer= i;
                break;
            }
        }
        return answer;
    }
    static void dfs(String s, int len){
        list.add(s);
        if(len==5)return;
        for(int i=0;i<5;i++){
            dfs(s+c[i],len+1);
        }
    }
}