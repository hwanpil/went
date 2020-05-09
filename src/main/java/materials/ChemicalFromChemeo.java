package materials;

import base.Value;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChemicalFromChemeo implements ChemicalDatabase {
    private final static Logger LOGGER = LoggerFactory.getLogger(ChemicalFromChemeo.class);
    public static ChemicalFromChemeo newInstance() {
        return singlet;
    }

    private static final String URLCHEMEO = "https://www.chemeo.com/search?q=";
    private static ChemicalFromChemeo singlet = new ChemicalFromChemeo();
    private ChemicalFromChemeo(){}

    @Override
    public Chemical pull(String name, String cas) {
        Map<String, Value> results = parseByJsoup(URLCHEMEO + cas);
        return new ChemicalImpl(name, cas, results);
    }

    private Map<String, Value> parseByJsoup(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Element content = doc.select("div#details-content table").first();
            Elements trs = content.select("tbody tr");
            Map<String, Value> res = new HashMap<>();
            for (Element ele : trs) {
                if (ele.className().startsWith("hide")){
                    continue;
                }
                String title = ele.selectFirst("td span").attr("title");
                String val = ele.selectFirst("td.r").text();
                String unit = ele.selectFirst("td.c").text();
                res.put(title, new Value(average(val), unit));
            }
            return res;
        } catch (IOException e) {
            LOGGER.warn("{} cannot be pulled!", url);
        } catch (Exception e){
            LOGGER.error(e.toString());
        }
        return new HashMap<>();
    }

    private double average(String val) {
        if (val.startsWith("[")){
            val = val.substring(1, val.length() - 1);
            return splitAndGetDouble(val, ";");
        }
        if (val.contains("±")){
            return Double.parseDouble(val.split("±")[0].trim());
        }
        return Double.parseDouble(val.trim());
    }

    private double splitAndGetDouble(String val, String s) {
        String[] strs = val.split(s);
        double res = 0;
        for (String str : strs) {
            res += Double.parseDouble(str.trim());
        }
        return res / 2;
    }
}
