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
		String url = "https://www.du.ac.kr/submenu.do?menuUrl=I9D4yBgHJGlG1TUOf%2fpDHQ%3d%3d&";	// 식단표 주소
		String className = "table-type01";	// 식단표 포함 페이지의 식단표 클래스명
		Document doc = Jsoup.connect(url).get();	// 페이지 정보를 받아옴
		Elements tr = doc.select("." + className).select("td");	// 클래스명이 className인 테이블의 td요소의 내용을 받아옴
		String html = tr.toString();
		html = html.replace("<td class=\"left\">", "");
		html = html.replace("*식자재 수급에 따라 변동될수있습니다.", "");
		html = html.replace(" ", "");
		html = html.replace("\n", "");	// 쓸모없는 요소들을 삭제

		List<List<String>> week = new ArrayList<List<String>>();	// 요일별 식단표(리스트)가 들은 리스트
		for (int j = 0; j < 5; j++) {	// 월,화,수,목,금 총 5개
			List<String> foods = new ArrayList<String>();	// 각 요일의 리스트
			for (int i = 0; i < 10; i++) {	// 하루의 총 반찬개수
				if (html.indexOf("</td>") == 0) {
					html = html.substring(5);	
					break;	// 한 요일의 끝을 기준으로 반복문을 종료
				}
				int breakPoint = html.indexOf("<br>");	
				String temp = html.substring(0, breakPoint);	// br을 기준으로 문자열(반찬)을 하나씩 추출
				foods.add(temp);	// 추출한 반찬을 리스트에 삽입
				html = html.substring(breakPoint + 4);	// br을 기준으로 구분했으므로 <br>태그의 종료위치를 기준으로 문자열을 자름
			}
			week.add(foods);	// 요일별 식단표 리스트에 각 요일의 식단표 리스트를 삽입
		}
		return week;
	}
}
