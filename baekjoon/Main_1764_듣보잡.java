package hash;

import java.io.*;
import java.util.*;

public class Main_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> map = new HashSet<>();

        for (int i = 0; i <n; i++) {
            String s = br.readLine();
            map.add(s);
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <m; i++) {
            String s = br.readLine();
            if(map.contains(s)){
                result.add(s);
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for (int i = 0; i <result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
