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

	/** 응모자 아이디 중 불량 사용자의 수만큼 탐색 */
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

	/** 응모자 아이디의 조합이 불량 사용자인지 판별 */
	static boolean isBannedUsers(Set<String> set) {

		int index = 0;

		for (String userId : set) {
			if (!isSameId(bannedIdArr[index++], userId))
				return false;
		}

		return true;
	}

	/** 특정 응모자 아이디가 불량 사용자인지 판별 */
	static boolean isSameId(String bannedId, String userId) {

		/* 불량 사용자와 응모자 아이디의 길이가 다른 경우 */
		if (bannedId.length() != userId.length())
			return false;

		/* 불량 사용자와 응모자 아이디의 길이가 같은 경우 */
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