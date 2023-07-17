package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_16235_나무제테크 {
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,1,-1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int[][] food = new int[n][n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        ArrayList<Tree> tree = new ArrayList<>();
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            tree.add(new Tree(r,c,z));
        }

        while (k-->0){
            ArrayList<Tree> die = new ArrayList<>();
            ArrayList<Tree> live = new ArrayList<>();
            Collections.sort(tree);
            //spring
            for (int i = 0; i <tree.size(); i++) {
                Tree t = tree.get(i);
                if(t.age>map[t.x][t.y]){
                    die.add(t);
                }else{
                    map[t.x][t.y] -=t.age;
                    t.age++;
                    live.add(t);
                }
            }
            tree.clear();
            tree.addAll(live);

            //summer
            for (int i = 0; i <die.size(); i++) {
                Tree t = die.get(i);
                map[t.x][t.y]+= t.age/2;
            }

            //fall
            for (int i = 0; i <live.size(); i++) {
                Tree t = live.get(i);
                if(t.age%5==0){
                    for (int d = 0; d <8; d++) {
                        int nx = t.x + dx[d];
                        int ny = t.y + dy[d];
                        if(nx<0||ny<0||nx>=n||ny>=n)continue;
                        tree.add(new Tree(nx,ny,1));
                    }
                }
            }

            //winter
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <n; j++) {
                    map[i][j]+=food[i][j];
                }
            }
        }
        System.out.println(tree.size());

    }

    private static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;
        public Tree(int x, int y,int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
