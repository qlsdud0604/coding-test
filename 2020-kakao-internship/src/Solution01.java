import java.io.*;
import java.util.*;

class Solution01 {
	static int currentLeft = 10;
	static int currentRight = 12;

	static String[] result;

	static int[][] coordinates = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
			{ 2, 2 }, { 3, 0 }, { 3, 1 }, { 3, 2 } };

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		System.out.println(solution(numbers, hand));
	}

	static public String solution(int[] numbers, String hand) {

		result = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];

			if (number == 0)
				number = 11;

			System.out.println(currentLeft + ", " + currentRight);

			/** 숫자가 1, 4, 7인 경우 */
			if (number == 1 || number == 4 || number == 7) {
				result[i] = "L";
				currentLeft = number;
			}
			/** 숫자가 3, 6, 9인 경우 */
			else if (number == 3 || number == 6 || number == 9) {
				result[i] = "R";
				currentRight = number;
			}
			/** 숫자가 2, 5, 8, 0인 경우 */
			else {
				int[] leftCoordinate = coordinates[currentLeft - 1];
				int[] rightCoordinate = coordinates[currentRight - 1];
				int[] currentCoordinate = coordinates[number - 1];

				int leftLength = Math.abs(currentCoordinate[0] - leftCoordinate[0])
						+ Math.abs(currentCoordinate[1] - leftCoordinate[1]);
				int rightLength = Math.abs(currentCoordinate[0] - rightCoordinate[0])
						+ Math.abs(currentCoordinate[1] - rightCoordinate[1]);

				if (leftLength == rightLength) {
					if (hand.equals("right")) {
						result[i] = "R";
						currentRight = number;
					} else {
						result[i] = "L";
						currentLeft = number;
					}
				} else if (leftLength > rightLength) {
					result[i] = "R";
					currentRight = number;
				} else if (leftLength < rightLength) {
					result[i] = "L";
					currentLeft = number;
				}

			}

		}

		String answer = "";

		for (int i = 0; i < result.length; i++)
			answer += result[i];

		return answer;
	}
}