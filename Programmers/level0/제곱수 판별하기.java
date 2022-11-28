class Solution {
    
    public int solution(int n) {

//         int answer = 2;
        
//         for(int i=1;i<=1000;i++){
//            int num = (int)Math.pow(i,2);
//             if(num == n){
//                 answer=1;
//                 break;
//             }
//         }
//         return answer;
        
        //2 번째
        // if(n%Math.sqrt(n)==0){
        //     return 1;
        // }else{
        //     return 2;
        // }
        
        //3번째
        return n%Math.sqrt(n)==0 ? 1 : 2 ;
    }
}