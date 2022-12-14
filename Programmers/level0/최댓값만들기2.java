import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int max  = numbers[numbers.length-1]*numbers[numbers.length-2];
        int min = numbers[0]*numbers[1];
        int answer = (max>=min) ? max : min;
        return answer;
    }
}
