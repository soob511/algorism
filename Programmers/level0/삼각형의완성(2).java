import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int answer =0;
        //가장 긴변이 sides[1] 인 경우
        for(int i=1;i<=sides[1];i++){
            if(i+sides[0]>sides[1]){
                answer ++;
            }
        }
        //나머지 한변이 가장 긴 변인 경우
        answer +=sides[0]-1;
        return answer;
    }
}
