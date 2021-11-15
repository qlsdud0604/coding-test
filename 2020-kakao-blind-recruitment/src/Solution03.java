import java.io.*;
import java.util.*;

public class Solution03 {
	static int N; // key의 길이
	static int M; // lock의 길이

	public boolean solution(int[][] key, int[][] lock) {
		N = key.length;
		M = lock.length;

		for (int x = 0; x < N - 1 + M; x++) {
			for (int y = 0; y < N - 1 + M; y++) {

				/** key 회전 */
				for (int r = 0; r < 4; r++) {
					int[][] extendedLock = new int[M + 2 * (N - 1)][M + 2 * (N - 1)];

					/** expandLock 초기화 */
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							extendedLock[i + N - 1][j + N - 1] = lock[i][j];
						}
					}
					compare(key, extendedLock, x, y, r);

					if (check(extendedLock, x, y))
						return true;
				}

			}
		}

		return false;
	}

	/** 회전한 key를 extendedLock과 비교 */
	static void compare(int[][] key, int[][] extendedLock, int x, int y, int r) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (r == 0) {
					extendedLock[i + x][j + y] += key[i][j];
				} else if (r == 1) {
					extendedLock[i + x][j + y] += key[N - 1 - j][i];
				} else if (r == 2) {
					extendedLock[i + x][j + y] += key[N - 1 - i][N - 1 - j];
				} else if (r == 3) {
					extendedLock[i + x][j + y] += key[j][N - 1 - i];
				}
			}
		}
	}

	/** 회전한 key가 extendedLock와 맞는지 확인 */
	static boolean check(int[][] extendedLock, int x, int y) {

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (extendedLock[i + N - 1][j + N - 1] != 1)
					return false;
			}
		}

		return true;
	}
}