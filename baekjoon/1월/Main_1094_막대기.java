package implement;

import java.util.Scanner;

public class Main_1094_막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int cnt = 0;
        int n = 64;
        while (x>0){
            if(n>x){
                n/=2;
            }else{
                cnt++;
                x-=n;
            }
        }
        System.out.println(cnt);
    }
}
