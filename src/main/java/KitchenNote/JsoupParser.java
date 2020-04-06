package KitchenNote;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Document google1 = Jsoup.connect("https://haemukja.com/main").get();
			Document google2 = Jsoup.connect("https://haemukja.com/main").get();
			Elements el = google1.getElementsByAttribute("data-id");
			Elements e2 = google2.getElementsByAttribute("ingre_id");
			
			Map<Integer,String> list = new HashMap<>();
			Map<Integer,String> ing_list = new HashMap<>();
			for (Element element : el) {
				int key = Integer.parseInt(element.attr("data-id"));
				list.put(key, element.text());
				System.out.println(list);
				
			}
			
			for(Element e : e2) {
				int id = Integer.parseInt(e.attr("ingre_id"));
				String str = e.select("strong").text();
				System.out.println(id+str);
				
			}
						

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
