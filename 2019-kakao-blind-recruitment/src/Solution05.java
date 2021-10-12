import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution05 {
	static HashMap<String, Page> map = new HashMap<>();

	public int solution(String word, String[] pages) {

		/** pages �迭�� �� ���������� Ž�� */
		for (int i = 0; i < pages.length; i++) {
			String html = pages[i];

			Page page = new Page(html.toLowerCase(), i);

			page.getDefaultPoint(word.toLowerCase()); // �� ���������� �⺻������ ���
			page.getLinkCount(); // �� ���������� �ܺ� ��ũ���� ���
			map.put(page.url, page);
		}

		for (Page page : map.values())
			page.getLinkPoint();

		ArrayList<Page> list = new ArrayList<>(map.values());

		Collections.sort(list);

		return list.get(0).index;
	}

	/** �� �������� ������ ������ ���� */
	static class Page implements Comparable<Page> {
		String html; // �������� html ����

		String url;

		int index; // �������� ��ȣ
		int defaultPoint; // �������� �⺻����
		int linkCount; // �������� �ܺ� ��ũ��
		double linkPoint; // ��ũ����

		Page(String html, int index) {
			this.html = html;
			this.index = index;

			getUrl();
		}

		/* html�� �������� �ش� �������� url�� Ž�� */
		void getUrl() {
			Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
			Matcher matcher = pattern.matcher(this.html);

			while (matcher.find())
				this.url = matcher.group(1);
		}

		/* �ش� �������� �⺻������ ����ϴ� �޼��� */
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

		/* �ش� �������� �ܺ� ��ũ���� ����ϴ� �޼��� */
		void getLinkCount() {
			int index = html.indexOf("<a href=");

			while (index != -1) {
				this.linkCount++;

				index = html.indexOf("<a href=", index + 1);
			}
		}

		/* �ش� �������� ��ũ������ ����ϴ� �޼��� */
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