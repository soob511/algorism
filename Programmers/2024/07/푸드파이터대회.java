class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1;i<food.length;i++){
            if(food[i]%2==1){
                food[i] = food[i]-1;
            }
            int num = food[i]/2;
            for(int j=0;j<num;j++){
                answer += i;
            }
        }
        StringBuilder sb = new StringBuilder(answer);
        String s = sb.reverse().toString();
        answer += '0';
        answer += s;
        return answer;
    }
}