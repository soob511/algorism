class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String s = "";
        for(int i=0;i<my_string.length();i++){
            if(my_string.charAt(i)>=65&&my_string.charAt(i)<=119){
                s += " ";
            }else{
                s += my_string.charAt(i);
            }
        }
        System.out.println(s);
         String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals("")){
                 answer += Integer.parseInt(arr[i]);
            }
        }
        
        return answer;
    }
}


class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split("[a-zA-Z]");
        for(int i=0;i<str.length;i++){
            if(!str[i].equals("")){
                answer += Integer.parseInt(str[i]);
            }
        }
        return answer;
    }
}
