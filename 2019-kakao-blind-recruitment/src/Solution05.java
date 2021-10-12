import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution05 {
	static HashMap<String, Page> map = new HashMap<>();

	public int solution(String word, String[] pages) {

		/** pages 배열의 각 페이지들을 탐색 */
		for (int i = 0; i < pages.length; i++) {
			String html = pages[i];

			Page page = new Page(html.toLowerCase(), i);

			page.getDefaultPoint(word.toLowerCase()); // 각 페이지들의 기본점수를 계산
			page.getLinkCount(); // 각 페이지들의 외부 링크수를 계산
			map.put(page.url, page);
		}

		for (Page page : map.values())
			page.getLinkPoint();

		ArrayList<Page> list = new ArrayList<>(map.values());

		Collections.sort(list);

		return list.get(0).index;
	}

	/** 각 페이지가 가지는 정보를 정의 */
	static class Page implements Comparable<Page> {
		String html; // 페이지의 html 정보

		String url;

		int index; // 페이지의 번호
		int defaultPoint; // 페이지의 기본점수
		int linkCount; // 페이지의 외부 링크수
		double linkPoint; // 링크점수

		Page(String html, int index) {
			this.html = html;
			this.index = index;

			getUrl();
		}

		/* html의 정보에서 해당 페이지의 url을 탐색 */
		void getUrl() {
			Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
			Matcher matcher = pattern.matcher(this.html);

			while (matcher.find())
				this.url = matcher.group(1);
		}

		/* 해당 페이지의 기본점수를 계산하는 메서드 */
		void getDefaultPoint(String word) {
			int index = html.indexOf(word);

			while (index != -1) {
				char pre = html.charAt(index - 1);
				char post = html.charAt(index + word.length());

				if (!Character.isLowerCase(pre) && !Character.isLowerCase(post))
					this.defaultPoint++;

				index = html.indexOf(word, index + 1);
			}
		}

		/* 해당 페이지의 외부 링크수를 계산하는 메서드 */
		void getLinkCount() {
			int index = html.indexOf("<a href=");

			while (index != -1) {
				this.linkCount++;

				index = html.indexOf("<a href=", index + 1);
			}
		}

		/* 해당 페이지의 링크점수를 계산하는 메서드 */
		void getLinkPoint() {
			Pattern pattern = Pattern.compile("<a href=\"https://(.+?)\">");
			Matcher matcher = pattern.matcher(html);

			while (matcher.find()) {
				String externalUrl = matcher.group(1);

				if (map.containsKey(externalUrl)) {
					map.get(externalUrl).linkPoint += (double) this.defaultPoint / this.linkCount;
				}
			}
		}

		@Override
		public int compareTo(Page o) {
			double x = this.defaultPoint + this.linkPoint;
			double y = o.defaultPoint + o.linkPoint;

			return Double.compare(y, x);
		}

	}
}