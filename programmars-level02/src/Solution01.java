import java.io.*;
import java.util.*;

public class Solution01 {
	public boolean solution(String[] phone_book) {

		Set<String> set = new HashSet<>();

		for (String number : phone_book)
			set.add(number);

		boolean answer = true;

		for (String number : phone_book) {
			for (int i = 0; i < number.length(); i++) {
				if (set.contains(number.substring(0, i)))
					return false;
			}
		}

		return answer;
	}
}
