package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1009_분산처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int data = 1;
            for (int j = 0; j <b; j++) {
                data = (data*a)%10;
            }
            if(data==0){
                sb.append(10+"\n");
            }else{
                sb.append(data + "\n");
            }
        }
        System.out.println(sb);
    }
}

//Math.pow 사용 메모리 초과