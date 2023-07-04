package implement;

import java.util.Scanner;

public class Main_1475_방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] arr = new int[9];

        for(int i=0; i<n.length();i++){
            int num = n.charAt(i)-'0';
            if(num==9){
                num=6;
            }
            arr[num]++;
        }

        int max=0;
        for(int i=0;i<9;i++){
            if(i==6){
                if(arr[i]%2==0){
                    arr[i]/=2;
                }else{
                    arr[i]=(arr[i]/2)+1;
                }
            }
            max = Math.max(max,arr[i]);
        }
        System.out.println(max);

    }
}
