class Solution {
    public int solution(int chicken) {
        int answer = -1;
       while(true){
           answer+=chicken/10;
           int c = chicken%10;
           chicken/=10;
           if(chicken==1){
               answer +=c;
               break;
           }
       }
        return answer;
    }
}
