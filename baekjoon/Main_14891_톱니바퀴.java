package implement;

import java.util.*;
import java.io.*;

public class Main_14891_톱니바퀴 {
    static int[][] gear;
    static int[] pole;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[5][9];
        for (int i = 1; i <=4; i++) {
            String s = br.readLine();
            for (int j = 0; j<=7 ; j++) {
                gear[i][j+1] = (int) s.charAt(j)-'0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i <k; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pole = new int[5];
            pole[num] = d;
            check(num);
            rotation();
        }
        if(gear[1][1]==1){
            sum+=1;
        }if(gear[2][1]==1){
            sum+=2;
        }if(gear[3][1]==1){
            sum+=4;
        }if(gear[4][1]==1){
            sum+=8;
        }
        System.out.println(sum);
    }

    private static void rotation() {
        for (int i = 1; i <=4; i++) {
            if(pole[i]==1){
                int temp = gear[i][8];
                for (int j = 8; j >=2; j--) {
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][1] = temp;
            }else if(pole[i]==-1){
                int temp = gear[i][1];
                for (int j = 1; j <=7; j++) {
                    gear[i][j] = gear[i][j+1];
                }
                gear[i][8] = temp;
            }
        }

    }
    private static void check(int num) {
        for (int i = num; i <4; i++) {
            if(gear[i][3]!=gear[i+1][7]){
                pole[i+1]=-pole[i];
            }
        }
        for (int i = num; i>=2; i--) {
            if(gear[i][7]!=gear[i-1][3]){
                pole[i-1]=-pole[i];
            }
        }
    }
}
