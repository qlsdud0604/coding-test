import java.io.*;
import java.util.*;

public class BOJ_1764 {
	static int N;
	static int M;

	static HashSet<String> hashSet = new HashSet<String>();
	static ArrayList<String> resultList = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++)
			hashSet.add(br.readLine());

		for (int i = 0; i < M; i++) {
			String input = br.readLine();

			if (hashSet.contains(input))
				resultList.add(input);
		}

		Collections.sort(resultList);

		bw.write(resultList.size() + "\n");

		for (String string : resultList) {
			bw.write(string + "\n");
		}

		bw.close();
	}
}
