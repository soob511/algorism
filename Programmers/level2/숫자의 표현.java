//주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 원리가 있다.
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=i;j<=n;j++){
                 sum+=j;
                if(sum==n){
                    answer++;
                    break;
                 }else if(sum>n){
                    break;
                }
            }
        }
    return answer;
    }
}