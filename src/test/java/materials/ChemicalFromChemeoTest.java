package materials;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ChemicalFromChemeoTest {

    @Test
    public void pull() throws IOException {
//        Document doc = Jsoup.connect("https://www.chemeo.com/search?q=11-65-9").get();
        Document doc = Jsoup.parse(new File("src/test/test.html"), "UTF-8");
        Element content = doc.select("div#details-content table").first();
        Elements trs = content.select("tbody tr");
        Map<String, String> res = new HashMap<>();
        for (Element ele : trs) {
            if (ele.className().startsWith("hide")){
                continue;
            }
            String title = ele.selectFirst("td span").attr("title");
            String val = ele.selectFirst("td.r").text();
            String unit = ele.selectFirst("td.c").text();
            res.put(title, val + "#" + unit);
        }
        System.out.println(res);
    }
}