import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {
	public static void main(String[] args) throws IOException {
		String url = "https://www.du.ac.kr/submenu.do?menuUrl=I9D4yBgHJGlG1TUOf%2fpDHQ%3d%3d&";
		String className = "table-type01";
		Document doc = Jsoup.connect(url).get();
		Elements e = doc.select("."+className);
		
		
	}
}
