import java.util.*;
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        for(int i=0;i<keyinput.length;i++){
            if(keyinput[i].equals("up")){
                answer[1]++;
                if(answer[1]>board[1]/2){
                    answer[1]--;
                }
            }else if(keyinput[i].equals("down")){
                answer[1]--;
                if(answer[1]<-board[1]/2){
                    answer[1]++;
                }
            }
            else if(keyinput[i].equals("left")){
                answer[0]--;
                 if(answer[1]<-board[0]/2){
                    answer[1]++;
                }
            }
            else if(keyinput[i].equals("right")){
                answer[0]++;
                if(answer[1]>board[0]/2){
                    answer[1]--;
                }
                
            }
            //System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
}
