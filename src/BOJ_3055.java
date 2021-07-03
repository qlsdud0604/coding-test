import java.io.*;
import java.util.*;

public class BOJ_3055 {
	static int R;
	static int C;

	static String[][] arr;
	static boolean[][] visited;
	static int[][] result;

	static int[] row = { -1, 0, 1, 0 };
	static int[] col = { 0, 1, 0, -1 };

	static int startX, startY;
	static int endX, endY;

	static Queue<Node> waterQueue = new LinkedList<Node>();
	static Queue<Node> animalQueue = new LinkedList<Node>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new String[R][C];
		visited = new boolean[R][C];
		result = new int[R][C];

		for (int i = 0; i < R; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				arr[i][j] = input[j];

				if (arr[i][j].equals("S")) {
					startX = i;
					startY = j;
					arr[i][j] = ".";
				}

				if (arr[i][j].equals("D")) {
					endX = i;
					endY = j;
				}

				if (arr[i][j].equals("*")) {
					waterQueue.add(new Node(i, j, 0));
				}
			}
		}

		bfs(startX, startY);

		if (result[endX][endY] == 0)
			bw.write("KAKTUS" + "\n");
		else
			bw.write(result[endX][endY] + "\n");

		bw.close();
	}

	/* 그래프 탐색 */
	static void bfs(int x, int y) {
		animalQueue.add(new Node(x, y, 0));

		while (!animalQueue.isEmpty()) {

			int size = waterQueue.size();

			for (int i = 0; i < size; i++) {
				Node waterNode = waterQueue.poll();

				for (int j = 0; j < 4; j++) {
					int nextWaterX = waterNode.x + row[j];
					int nextWaterY = waterNode.y + col[j];

					if (checkRange(nextWaterX, nextWaterY) && arr[nextWaterX][nextWaterY].equals(".")) {
						arr[nextWaterX][nextWaterY] = "*";
						waterQueue.add(new Node(nextWaterX, nextWaterY, 0));
					}
				}
			}

			size = animalQueue.size();

			for (int i = 0; i < size; i++) {
				Node animalNode = animalQueue.poll();
				visited[animalNode.x][animalNode.y] = true;

				for (int j = 0; j < 4; j++) {
					int nextAnimalX = animalNode.x + row[j];
					int nextAnimalY = animalNode.y + col[j];

					if (check(nextAnimalX, nextAnimalY)) {
						animalQueue.add(new Node(nextAnimalX, nextAnimalY, animalNode.count + 1));
						visited[nextAnimalX][nextAnimalY] = true;

						result[nextAnimalX][nextAnimalY] = animalNode.count + 1;
					}
				}
			}
		}
	}

	/* 고슴도치 이동 가능 여부 확인 */
	static boolean check(int x, int y) {
		if (x < 0 || R <= x || y < 0 || C <= y)
			return false;

		if (visited[x][y] == true || arr[x][y].equals("X") || arr[x][y].equals("*"))
			return false;

		return true;
	}

	/* 범위 확인 */
	static boolean checkRange(int x, int y) {
		if (x < 0 || R <= x || y < 0 || C <= y)
			return false;

		return true;
	}

	/* 현재 위치에 대한 클래스 */
	static class Node {
		int x;
		int y;
		int count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
