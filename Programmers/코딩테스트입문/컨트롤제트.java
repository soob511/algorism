class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        int num = 0;
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("Z")){
                answer+=Integer.parseInt(arr[i]);
                num = Integer.parseInt(arr[i]);
            }else{
                answer -= num;
            }
        }
        return answer;
    }
}
