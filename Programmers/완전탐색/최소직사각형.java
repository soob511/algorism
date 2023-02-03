class Solution {
    public int solution(int[][] sizes) {
       int w_max = 0;
       int l_max = 0;
       for(int i=0;i<sizes.length;i++){
           int width = Math.max(sizes[i][0],sizes[i][1]);
           int lenth = Math.min(sizes[i][0],sizes[i][1]);
           w_max = Math.max(w_max,width);
           l_max = Math.max(l_max,lenth);
       }
        return w_max*l_max;
    }
}