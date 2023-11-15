class Solution {
    public int gcd(int n, int m){
        while(m>0){
            int tmp = n;
            n = m;
            m = tmp%m;
        }
        return n;
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n<m){
            int temp = n;
            n = m;
            m = temp;
        }
        answer[0] = gcd(n,m);
        answer[1] = n*m / answer[0];
        return answer;
    }
}
