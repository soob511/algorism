class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>64&&c<91){
                answer += (char)(c+32);
            }else{
                answer += (char)(c-32);
            }
        }
        return answer;
    }
}
               //A = 65
               //a = 97
