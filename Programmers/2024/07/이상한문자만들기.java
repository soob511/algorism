class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ", -1); // 공백을 포함한 split 처리
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length(); j++){
                char c = arr[i].charAt(j);
                if(j % 2 == 0){
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                answer +=c;
            }
            if(i < arr.length - 1){
                answer+=" ";
            }
        }
        return answer;
    }
}
