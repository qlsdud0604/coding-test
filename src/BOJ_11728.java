import java.io.*;
import java.util.*;

public class BOJ_11728 {
	static int N;
	static int M;

	static int[] A;
	static int[] B;

	static int[] C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[M];
		C = new int[N + M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			B[i] = Integer.parseInt(st.nextToken());

		twoPointers();

		for (int i = 0; i < C.length; i++)
			bw.write(C[i] + " ");

		bw.close();
	}

	static void twoPointers() {
		int A_Index = 0;
		int B_Index = 0;
		int C_Index = 0;

		while (A_Index < N && B_Index < M) {
			if (A[A_Index] <= B[B_Index])
				C[C_Index++] = A[A_Index++];
			else
				C[C_Index++] = B[B_Index++];
		}

		while (A_Index < N)
			C[C_Index++] = A[A_Index++];

		while (B_Index < M)
			C[C_Index++] = B[B_Index++];
	}
}
