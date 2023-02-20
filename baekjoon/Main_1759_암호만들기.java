package implement;

import java.io.*;
import java.util.*;

public class Main_1759_암호만들기 {
    static int l,c;
    static char[] arr;
    static char[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         l  = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

         arr = new char[c];
         select = new char[l];
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i <c; i++) {
           arr[i] = st.nextToken().charAt(0);
         }
        Arrays.sort(arr);
        per(0,0);
    }

    private static void per(int cnt,int start) {
        if(cnt==l){
            if(code()){
                System.out.println(select);
            }
            return;
        }
        for (int i = start; i <c; i++) {
                select[cnt] = arr[i];
                per(cnt+1,i+1);
            }
    }


    private static boolean code() {
        int z = 0;
        int m = 0;
        for(char x:select){
            if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'){
                m++;
            }else{
                z++;
            }
        }
        if(m>=1&&z>=2){
            return true;
        }
        return false;

    }
}
