package samsung;

import java.io.*;
import java.util.*;

public class Main_싸움땅 {
	static class Player {
		int x;
		int y;
		int d;
		int s;
		int gun;// 가지고있는총
		int score;// 점수
		
		public Player(int x, int y, int d, int s, int gun, int score) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			this.gun = gun;
			this.score = score;
		}
	}

	static int n, m, k;
	static int[] dx = { -1, 0, 1, 0 };// 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };
	static Player[] player;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer>[][] map = new PriorityQueue[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = new PriorityQueue<>(Collections.reverseOrder());
				int a = Integer.parseInt(st.nextToken());
				if (a > 0) {
					map[i][j].add(a);
				}
			}
		}
		player = new Player[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			player[i] = new Player(x, y, d, s, 0, 0);
		}

		while (k-- > 0) {
			for (int i = 0; i < m; i++) {
				Player a = player[i];
				int dir = a.d;
				int nx = a.x + dx[dir];
				int ny = a.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n) {// 범위 벗어나면 방향 바꿈
					dir = (dir + 2) % 4;
					nx = a.x + dx[dir];
					ny = a.y + dy[dir];
				}

				Player b = check(nx, ny);// 이동할 칸에 플레이어 확인

				// 한칸 이동
				a.x = nx;
				a.y = ny;
				a.d = dir;

				if (b == null) {// 플레이어 없다면
					if (map[a.x][a.y].size() > 0) {// 총이 있는지 확인
						if (a.gun == 0) {// 내가 총이 없으면
							a.gun = map[a.x][a.y].poll();
						} else {// 총 내려놓고 제일 쎈총 주움
							map[a.x][a.y].add(a.gun);
							a.gun = map[a.x][a.y].poll();
						}

					}

				} else {// 플레이어 있다면
					Player winner = null;
					Player loser = null;

					int asum = a.s + a.gun;
					int bsum = b.s + b.gun;
					if (asum > bsum) {
						winner = a;
						loser = b;
					} else if (asum < bsum) {
						winner = b;
						loser = a;
					} else if (asum == bsum) {// 동점
						if (a.s > b.s) {
							winner = a;
							loser = b;
						} else {
							winner = b;
							loser = a;
						}
					}
					int point = Math.abs(asum - bsum);
					winner.score += point;

					// 진플레이어
					map[loser.x][loser.y].add(loser.gun);// 총 내려놓기
					loser.gun = 0;

					for (int j = loser.d; j < loser.d + 4; j++) {
						nx = loser.x + dx[j % 4];
						ny = loser.y + dy[j % 4];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || check(nx, ny) != null) {
							continue;
						}
						loser.x = nx;
						loser.y = ny;
						loser.d = j % 4;
						if (map[loser.x][loser.y].size() > 0) {
							loser.gun = map[loser.x][loser.y].poll();
						}
						break;
					}

					// 이긴플레이어
					map[winner.x][winner.y].add(winner.gun);
					winner.gun = map[winner.x][winner.y].poll();
				}

			}
		}
		for (int i = 0; i < m; i++) {
			System.out.print(player[i].score + " ");
		}

	}

	private static Player check(int nx, int ny) {
		for (int i = 0; i < m; i++) {
			if (nx == player[i].x && ny == player[i].y) {
				return player[i];
			}
		}
		return null;
	}

}
