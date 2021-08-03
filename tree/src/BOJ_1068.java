import java.io.*;
import java.util.*;

public class BOJ_1068 {
	static int N;

	static ArrayList<Integer>[] nodes;

	static int[] parents;
	static boolean[] isLeaf;

	static int deletedNode;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		nodes = new ArrayList[N];
		parents = new int[N];
		isLeaf = new boolean[N];

		for (int i = 0; i < N; i++) {
			nodes[i] = new ArrayList<>();
		}

		Arrays.fill(isLeaf, true);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			parents[i] = Integer.parseInt(st.nextToken(" "));

			if (parents[i] != -1) {
				nodes[parents[i]].add(i);
				isLeaf[parents[i]] = false;
			}
		}

		deletedNode = Integer.parseInt(br.readLine());

		if (parents[deletedNode] != -1) {
			function(deletedNode, true);

			int result = 0;

			for (int i = 0; i < N; i++)
				if (isLeaf[i] == true)
					result++;

			bw.write(result + "\n");
		} else
			bw.write(0 + "\n");

		bw.close();
	}

	/* �� ��尡 ���� ������� �Ǻ��ϴ� �޼ҵ� */
	static void function(int deletedNode, boolean isFirst) {
		int node = deletedNode;

		isLeaf[node] = false;

		/* �θ� ��尡 ������ ��� �ϳ��� �ڽ����� ������ ��� �θ� ��带 ���� ���� ���� */
		if (nodes[parents[node]].size() == 1 && nodes[parents[node]].contains(node) && isFirst)
			isLeaf[node] = true;

		for (int data : nodes[node]) {
			isLeaf[data] = false;

			function(data, false);
		}
	}
}