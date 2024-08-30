import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class jsoup {
	public static void main(String[] args) throws IOException {
		String url = "https://www.du.ac.kr/submenu.do?menuUrl=I9D4yBgHJGlG1TUOf%2fpDHQ%3d%3d&";
		String className = "table-type01";
		Document doc = Jsoup.connect(url).get();
		Elements tr = doc.select("."+className).select("td");
		String html = tr.toString();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<5; i++) {
			int breakPoint = html.indexOf("</td>");
			String temp =html.substring(0,breakPoint);
			temp = temp.replace("<br>", "");
			temp = temp.replace("<td class=\"left\">", "");
			temp = temp.replace("*식자재 수급에 따라 변동될수있습니다.", "");
			temp = temp.replace(" ", "");
			map.put(i, temp);
			html = html.substring(breakPoint+5);
		}
		for(int i=0;i<map.size();i++) {
			System.out.println(map.get(i));						
		}
	}
}
