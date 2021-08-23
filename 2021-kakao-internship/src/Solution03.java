import java.util.*;

class Solution03 {
	public String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();

		int size = n;
		int current = k;

		for (int i = 0; i < cmd.length; i++) {
			char command = cmd[i].charAt(0);

			if (command == 'U') {
				current -= Integer.parseInt(cmd[i].substring(2));
			} else if (command == 'D') {
				current += Integer.parseInt(cmd[i].substring(2));
			} else if (command == 'C') {
				stack.push(current);

				size -= 1;

				if (current == size)
					current -= 1;
			} else {
				int pop = stack.pop();

				size += 1;

				if (pop <= current)
					current += 1;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append("O");
		}

		while (!stack.isEmpty()) {
			sb.insert(stack.pop(), "X");
		}

		return sb.toString();
	}
}