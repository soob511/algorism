class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String A = Integer.toBinaryString(arr1[i]);
            String B = Integer.toBinaryString(arr2[i]);
            A = String.format("%"+n+"s",A);
            B = String.format("%"+n+"s",B);
            answer[i] = "";
            for(int j=0;j<n;j++){
                if(A.charAt(j)=='1'||B.charAt(j)=='1'){
                    answer[i] += "#";
                }else{
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}
