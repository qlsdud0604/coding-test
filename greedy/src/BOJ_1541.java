import java.io.*;
import java.util.*;

public class BOJ_1541 {
	static String input;
	static String[] inputArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		input = br.readLine();

		inputArr = input.split("\\-");

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {

		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i].contains("+")) {
				String[] arr = inputArr[i].split("\\+");

				int number = 0;

				for (int j = 0; j < arr.length; j++) {
					number += Integer.parseInt(arr[j]);
				}
				inputArr[i] = number + "";
			}
		}

		int result = Integer.parseInt(inputArr[0]);

		for (int i = 1; i < inputArr.length; i++) {
			result -= Integer.parseInt(inputArr[i]);
		}

		return result;
	}

}
