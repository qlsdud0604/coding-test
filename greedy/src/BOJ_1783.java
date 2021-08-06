import java.io.*;
import java.util.*;

public class BOJ_1783 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		if (N == 1)
			return 1;
		else if (N == 2)
			return Math.min(4, (M + 1) / 2);
		else if (M < 7)
			return Math.min(4, M);
		else
			return M - 2;
	}

}
