import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = array.length/2;
        Arrays.sort(array);
        return array[answer];
    }
}