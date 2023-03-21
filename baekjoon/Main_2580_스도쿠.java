package backtracking;

import java.io.*;
import java.util.*;

public class Main_2580_스도쿠 {
    static int[][] map;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new LinkedList<>();
        for (int i = 0; i <9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    list.add(new Node(i,j));
                }
            }
        }
        dfs(0);

    }

    private static void dfs(int cnt) {
        if(cnt==list.size()){
            for (int i = 0; i <9; i++) {
                for (int j = 0; j <9; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        Node node = list.get(cnt);
        for (int i = 1; i <=9 ; i++) {
            if(check(node.x,node.y,i)){
                map[node.x][node.y] = i;
                dfs(cnt+1);
                map[node.x][node.y] = 0;
            }
        }
    }

    private static boolean check(int x, int y,int num) {
        for (int i = 0; i <9; i++) { //가로 세로 체크
            if(map[x][i]==num)return false;
            if(map[i][y]==num)return false;

        }
        int s = (x/3)*3;
        int t = (y/3)*3;
        for (int i =s; i <s+3; i++) {
            for (int j = t; j <t+3; j++) {
                if(map[i][j]==num)return false;
            }
        }

        return true;
    }
    public static class Node{
        int x;
        int y;
        public  Node(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
}
