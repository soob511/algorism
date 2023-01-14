package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2490_윷놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[3][4];
        for (int i = 0; i <3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <3; i++) {
            int count =0;
            for (int j = 0; j <4; j++) {
                if(map[i][j]==1){
                    count++;
                }
            }
            char result;
            if(count==1){
                result = 'C';
            }else if (count==2){
                result = 'B';
            }else if(count==3){
                result = 'A';
            }else if(count==4){
                result = 'E';
            }else{
                result = 'D';
            }
            System.out.println(result);
        }

    }
}
