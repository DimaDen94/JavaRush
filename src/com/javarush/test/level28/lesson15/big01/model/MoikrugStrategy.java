package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 24.02.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?page=%d&q=java+%s";
    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                if (doc == null) break;

                Elements elements = doc.getElementsByClass("job");

                if (elements.size() == 0) break;

                for (Element element : elements) {
                    // title
                    Element titleElement = element.getElementsByClass("title").first();
                    String title = titleElement.text();

                    // url
                    String url = "https://moikrug.ru" + titleElement.getElementsByTag("a").attr("href");

                    // salary
                    Element salaryElement = element.getElementsByClass("salary").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }

                    // city (it's important)
                    Element cityEl = element.getElementsByClass("location").first();
                    String city = "";
                    if (cityEl != null) {
                        city = cityEl.text();
                    }


                    // company
                    String companyName = element.getElementsByClass("company_name").first().text();

                    // site
                    String siteName = "http://moikrug.ru/";



                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);

                }

                //break;
            }
        }
        catch (Exception e) {
            //e.printStackTrace();
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {


        String url = String.format(URL_FORMAT, page, searchString);
        Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36")
                    .referrer("http://javarush.ru/")
                    .get();

        return document;
    }
}
