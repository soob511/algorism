import java.util.*;
class Solution {
    public int solution(int[] p, int location) {
        int answer = 0;
        int[] num = new int[p.length];
        for(int i=0;i<p.length;i++){
            num[i]=i;
        }
        while(true){
            int a = p[0];
            boolean pass = false;
            if(a!=0){
                for(int i=0;i<p.length;i++){
                    if(a<p[i]){
                        pass = true;
                    }
                }
            }
            if(a==0){
                pass = true;
            }
            if(pass){
                int temp = p[0];
                for(int i=1;i<p.length;i++){
                    p[i-1] = p[i];
                }
                p[p.length-1] = temp;
                temp = num[0];
                for(int i=1;i<p.length;i++){
                    num[i-1] = num[i];
                }
                num[p.length-1] = temp;
            }else{
                answer+=1;
                p[0] = 0;
                if(location==num[0]){
                    return answer;
                }
            }
        }
    }
}
