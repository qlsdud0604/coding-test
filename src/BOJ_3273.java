import java.io.*;
import java.util.*;

public class BOJ_3273 {
	static int N;

	static ArrayList<Integer> list = new ArrayList<Integer>();

	static int X;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));

		Collections.sort(list);

		X = Integer.parseInt(br.readLine());

		for (int i = 0; i < list.size(); i++) {
			count += function(i, list.size() - 1);
		}

		if (N == 1) {
			if (list.get(0) == X)
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		} else
			bw.write(count + "\n");

		bw.close();
	}

	static int function(int first, int last) {
		int start = first + 1;
		int end = last;

		int target = X - list.get(first);

		while (start <= end) {
			int middle = (start + end) / 2;

			if (list.get(middle) < target)
				start = middle + 1;
			else if (list.get(middle) > target)
				end = middle - 1;
			else if (list.get(middle) == target) {
				list.remove(middle);
				return 1;
			}
		}
		return 0;
	}
}
