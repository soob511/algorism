class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean flag = false;
        for(String word : dic){
            int count = 0;
            for(String s :spell){
                if(word.contains(s)){
                    count++;
                }
            }
            if(count==spell.length){
                flag = true;
                break;
            }
        }
        return flag ? 1:2;
    }
}
