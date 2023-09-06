import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        Integer[] avg = new Integer[score.length];
        int[] answer = new int[score.length];
        for(int i=0;i<score.length;i++){
                avg[i] = score[i][0]+score[i][1];
            
        }
        Arrays.sort(avg,Collections.reverseOrder());
        for(int i=0;i<score.length;i++){
            answer[i] = Arrays.asList(avg).indexOf(score[i][0]+score[i][1])+1;
        }
        return answer;
    }
}

//리스트로 변환 Arrays.asList()
//처음만나는 인덱스 indexOf
