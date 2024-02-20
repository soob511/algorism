import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2,s.length()-2);
        s = s.replace("},{","-");
        String[] arr = s.split("-");
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String o1, String o2){
                
                return Integer.compare(o1.length(),o2.length());
            }
        });
        for(int i=0;i<arr.length;i++){
            String[] temp = arr[i].split(",");
            for(int j=0;j<temp.length;j++){
                int n = Integer.parseInt(temp[j]);
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
            
        }
        return answer;
    }
}
