package hash;
import java.io.*;
import java.util.*;

public class Main_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> map = new HashMap<>();


        for (int i = 1; i <=n; i++) {
            String s = br.readLine();
            String num = Integer.toString(i);
            map.put(s,num);
            map.put(num,s);
        }
        for (int i = 0; i <m; i++) {
            String s = br.readLine();
            System.out.println(map.get(s));
        }

    }
}
