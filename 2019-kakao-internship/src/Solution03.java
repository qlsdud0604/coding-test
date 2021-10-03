import java.util.*;

class Solution03 {
	static Set<Set<String>> result;
	static String[] userIdArr;
	static String[] bannedIdArr;

	public int solution(String[] user_id, String[] banned_id) {
		result = new HashSet<Set<String>>();
		userIdArr = user_id;
		bannedIdArr = banned_id;

		dfs(new LinkedHashSet<>());

		return result.size();
	}

	/** ������ ���̵� �� �ҷ� ������� ����ŭ Ž�� */
	static void dfs(Set<String> set) {

		if (set.size() == bannedIdArr.length) {
			if (isBannedUsers(set)) {
				result.add(new HashSet<>(set));
			}
		}

		for (String userId : userIdArr) {
			if (!set.contains(userId)) {
				set.add(userId);

				dfs(set);

				set.remove(userId);
			}
		}
	}

	/** ������ ���̵��� ������ �ҷ� ��������� �Ǻ� */
	static boolean isBannedUsers(Set<String> set) {

		int index = 0;

		for (String userId : set) {
			if (!isSameId(bannedIdArr[index++], userId))
				return false;
		}

		return true;
	}

	/** Ư�� ������ ���̵� �ҷ� ��������� �Ǻ� */
	static boolean isSameId(String bannedId, String userId) {

		/* �ҷ� ����ڿ� ������ ���̵��� ���̰� �ٸ� ��� */
		if (bannedId.length() != userId.length())
			return false;

		/* �ҷ� ����ڿ� ������ ���̵��� ���̰� ���� ��� */
		for (int i = 0; i < bannedId.length(); i++) {
			char bannedIdChar = bannedId.charAt(i);
			char userIdChar = userId.charAt(i);

			if (bannedIdChar == userIdChar || bannedIdChar == '*')
				continue;
			else
				return false;
		}

		return true;
	}
}