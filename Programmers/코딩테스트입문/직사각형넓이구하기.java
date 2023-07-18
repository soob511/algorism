import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots,(o1,o2)->o1[0]==o2[0] ? o1[1]-o2[1]:o1[0]-o2[0]);
        int answer = (dots[1][1]-dots[0][1])*(dots[2][0]-dots[1][0]);
        return answer;
    }
}