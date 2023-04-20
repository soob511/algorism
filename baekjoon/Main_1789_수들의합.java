package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class Main_1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long num = 0;
        while (true){
            if(sum>n){
                break;
            }
            num++;
            sum+=num;
        }
        System.out.println(num-1);
    }
}
