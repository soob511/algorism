import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
          map.put(players[i],i);
        }
        for(int i=0;i<callings.length;i++){
          int lank = map.get(callings[i]);
          String temp = players[lank-1];
            players[lank-1] = players[lank];
            players[lank] = temp;
            map.put(temp,lank);
            map.put(callings[i],lank-1);
        }
        return players;
    }
}
