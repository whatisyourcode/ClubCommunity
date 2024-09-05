package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FoodService {
	public List<List<String>> getFoodList() throws IOException{
		String url = "https://www.du.ac.kr/submenu.do?menuUrl=I9D4yBgHJGlG1TUOf%2fpDHQ%3d%3d&";
		String className = "table-type01";
		Document doc = Jsoup.connect(url).get();
		Elements tr = doc.select("." + className).select("td");
		System.out.println(tr);
		String html = tr.toString();
		html = html.replace("<td class=\"left\">", "");
		html = html.replace("*식자재 수급에 따라 변동될수있습니다.", "");
		html = html.replace(" ", "");
		html = html.replace("\n", "");

		List<List<String>> week = new ArrayList<List<String>>();
		for (int j = 0; j < 5; j++) {
			List<String> foods = new ArrayList<String>();
			for (int i = 0; i < 10; i++) {
				if (html.indexOf("</td>") == 0) {
					html = html.substring(5);
					break;
				}
				int breakPoint = html.indexOf("<br>");
				String temp = html.substring(0, breakPoint);
				foods.add(temp);
				html = html.substring(breakPoint + 4);
			}
			week.add(foods);
		}
//		for (Integer w : week.keySet()) {
//			System.out.println(w);
//			for (Integer f : week.get(w).keySet()) {
//				System.out.println(week.get(w).get(f));
//			}
//		}
		return week;
	}
}
