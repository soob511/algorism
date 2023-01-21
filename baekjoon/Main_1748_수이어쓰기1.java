package implement;

import java.util.Scanner;

public class Main_1748_수이어쓰기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int length = 0;
        int num = 10;
        int count=1;
        for (int i = 1; i <=n; i++) {
            if(i==num){
                count++;
                num*=10;
            }
            length += count;
        }
        System.out.println(length);
    }
}
