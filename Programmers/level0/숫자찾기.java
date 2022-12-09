class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String s = num +"";
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i)-'0'==k){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
