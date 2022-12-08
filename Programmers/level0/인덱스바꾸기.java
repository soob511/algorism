class Solution {
    public String solution(String s, int num1, int num2) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            if(i==num1){
                answer += s.charAt(num2);
            }else if(i==num2){
                answer += s.charAt(num1);
            }else{
                answer+=s.charAt(i);
            }
        }
        return answer;
    }
}
