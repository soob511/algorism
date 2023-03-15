class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = (brown-4)/2;
        int x=0;
        int y =0;;
        for(int i=1;i<=n;i++){
            if(i*(n-i)==yellow){
                x=i;
                y=n-i;
            }
        }
        answer[0] = x+2;
        answer[1] = y+2;
        return answer;
    }
}