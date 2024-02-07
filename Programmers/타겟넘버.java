class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    public void dfs(int[] numbers,int target,int num,int sum){
        if(num==numbers.length){
            if(sum==target){
                answer++;
            }
            return;
        }
        dfs(numbers, target, num+1, sum+numbers[num]);
        dfs(numbers, target, num+1, sum-numbers[num]);
    }
}
