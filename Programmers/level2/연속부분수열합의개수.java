import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] arr = new int[elements.length*2];
        for(int i=0;i<arr.length;i++){
            arr[i] = elements[i%elements.length];
        }
        HashSet<Integer> hash = new HashSet<>();
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum = 0;
                for(int k=0;k<i;k++){
                    sum += arr[j+k];
                }
                hash.add(sum);
            }
        }
        return hash.size();
    }
}
