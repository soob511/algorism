class Solution {
    static int size;
    static int[] answer;
    public int[] solution(int[] numbers, String direction) {
        size = numbers.length;
        answer = new int[size];
        
        if(direction.equals("right")){
            
            answer[0] = numbers[size-1];
            for(int i=0;i<size-1;i++){
                answer[i+1] = numbers[i];
            }
        }
        else{
            answer[size-1] = numbers[0];
             for(int i=size-1;i>0;i--){
                answer[i-1] = numbers[i];
             }     
        }
        return answer;
    }
}
