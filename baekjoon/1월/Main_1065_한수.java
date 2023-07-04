package implement;

import java.util.*;

public class Main_1065_한수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<100){
            System.out.println(n);
        }else{
            int cnt = 99;
            for(int i=100;i<=n;i++){
                int one = i/100;
                int two = (i/10)%10;
                int three = i%10;
                if((one-two)==(two-three)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
