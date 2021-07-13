import java.io.*;
import java.util.*;

public class BOJ_14676 {
	static int SIZE = 100001;

	static int N; // 건물 종류의 개수
	static int M; // 건물 사이 관계의 개수
	static int K; // 게임 정보의 개수

	static ArrayList<Integer>[] arr;
	static int[] inDegree;
	static int[] construct;

	static boolean result = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new ArrayList[SIZE];
		inDegree = new int[SIZE];
		construct = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			arr[X].add(Y);
			inDegree[Y]++;
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int operation = Integer.parseInt(st.nextToken());
			int building = Integer.parseInt(st.nextToken());

			if (operation == 1) { // 건물 건설
				if (inDegree[building] == 0) { // 건물 건설이 가능한 경우
					construct[building]++;

					if (construct[building] == 1) {
						for (int j = 0; j < arr[building].size(); j++) { // 특정 번호의 건물이 최초 한 개 건설된 경우
							inDegree[arr[building].get(j)]--;
						}
					}

				} else
					result = false;
			} else { // 건물 파괴
				if (construct[building] > 0) { // 건물 파괴가 가능한 경우
					construct[building]--;

					if (construct[building] == 0) {
						for (int j = 0; j < arr[building].size(); j++) { // 특정 번호의 건물이 모두 파괴된 경우
							inDegree[arr[building].get(j)]++;
						}
					}

				} else
					result = false;
			}
		}

		if (result)
			bw.write("King-God-Emperor" + "\n");
		else
			bw.write("Lier!" + "\n");

		bw.close();
	}
}