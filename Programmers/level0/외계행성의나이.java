class Solution {
    public String solution(int age) {
        // String answer = "";
        // String s = String.valueOf(age);
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)=='0'){
        //         answer+="a";
        //     }else if(s.charAt(i)=='1'){
        //         answer+="b";
        //     }else if(s.charAt(i)=='2'){
        //         answer+="c";
        //     }else if(s.charAt(i)=='3'){
        //         answer+="d";
        //     }else if(s.charAt(i)=='4'){
        //         answer+="e";
        //     }else if(s.charAt(i)=='5'){
        //         answer+="f";
        //     }else if(s.charAt(i)=='6'){
        //         answer+="g";
        //     }else if(s.charAt(i)=='7'){
        //         answer+="h";
        //     }else if(s.charAt(i)=='8'){
        //         answer+="i";
        //     }else if(s.charAt(i)=='9'){
        //         answer+="j";
        //     }
        // }
        // return answer;
        
        String answer = "";
        char[] a = {'a','b','c','d','e','f','g','h','i','j'};
        while(age>=1){
            answer=a[age%10]+answer;
            age/=10;
        }
        return answer;
    }
}
