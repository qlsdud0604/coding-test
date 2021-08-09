import java.io.*;
import java.util.*;

public class BOJ_4796 {
	static int L;
	static int P;
	static int V;

	static int count = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0)
				break;

			bw.write("Case " + count + ": " + function() + "\n");

			count++;
		}
		bw.close();
	}

	static int function() {
		int result = 0;

		result += L * (V / P);

		if (V % P <= L)
			result += V % P;
		else
			result += L;

		return result;
	}

}
