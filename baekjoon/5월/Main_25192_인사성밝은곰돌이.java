package anything;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_25192_인사성밝은곰돌이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet hs = new HashSet();
        int n = Integer.parseInt(br.readLine());
        int count=0;
        for (int i = 0; i <n; i++) {
            String s = br.readLine();
            if(s.equals("ENTER")){
                hs.clear();
            }
            else if(!hs.contains(s)){
                hs.add(s);
                count++;
            }
        }
        System.out.println(count);
    }
}
