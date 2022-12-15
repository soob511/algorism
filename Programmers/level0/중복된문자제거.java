class Solution {
    public String solution(String s) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
          if(!answer.contains(c)){
              answer+=c+"";
          }
        }
        return answer;
    }
}
