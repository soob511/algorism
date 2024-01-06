class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            answer[0]++;;
            char[] c = s.toCharArray();
            s = "";
            for(int i=0;i<c.length;i++){
                if(c[i]=='0'){
                    answer[1]++;
                }else{
                    s+=1;   
                }
            }
           int l = s.length();
            s = Integer.toBinaryString(l);
        }
        return answer;
    }
}
