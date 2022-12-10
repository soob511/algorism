class Solution {
    public int solution(int a, int b, int k) {
        int answer = 0;
        for(int i=a;i<=b;i++){
            int num = i;
            while(num>0){
                if(num%10==k){
                    answer++;
                }
                num/=10;
            }
        }
        return answer;
    }
}
