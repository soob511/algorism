import java.util.*;
import java.io.*;
class Solution {
    public long solution(String numbers) {
        // numbers = numbers.replaceAll("zero","0");
        // numbers = numbers.replaceAll("one","1");
        // numbers = numbers.replaceAll("two","2");
        // numbers = numbers.replaceAll("three","3");
        // numbers = numbers.replaceAll("four","4");
        // numbers = numbers.replaceAll("five","5");
        // numbers = numbers.replaceAll("six","6");
        // numbers = numbers.replaceAll("seven","7");
        // numbers = numbers.replaceAll("eight","8");
        // numbers = numbers.replaceAll("nine","9");
        // long answer = Long.parseLong(numbers);
        // return answer;
        
        String[] arr = {"zero", "one", "two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<arr.length;i++){
            numbers = numbers.replaceAll(arr[i],i+"");
        }
        long answer = Long.parseLong(numbers);
        return answer;
    }
}
