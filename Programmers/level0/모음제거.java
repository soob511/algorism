class Solution {
    public String solution(String my_string) {
        // String answer = "";
        // String arr[] = my_string.split("");
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")||arr[i].equals("o")||arr[i].equals("u")){
        //         answer+="";
        //     }
        //     else{
        //         answer+=arr[i];
        //     }
        // }
        // return answer;
        
        String answer ="";
        answer = my_string.replaceAll("[aeiou]","");
        return answer;
    }
}
