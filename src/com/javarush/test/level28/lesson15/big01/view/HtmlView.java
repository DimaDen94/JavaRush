package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitry on 20.02.2016.
 */
public class HtmlView implements View
{
    Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    public void update(List<Vacancy> vacancies)
    {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
    public void userCitySelectEmulationMethod()
    {
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        String content;
        Document document;
        try
        {
            document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element cloneElement = element.clone();
            cloneElement.removeClass("template");
            cloneElement.removeAttr("style");


            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy: vacancies){
                Element nextCloneElement = cloneElement.clone();
                nextCloneElement.getElementsByClass("city").first().text(vacancy.getCity());
                nextCloneElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                nextCloneElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                nextCloneElement.getElementsByTag("a").first()
                        .text(vacancy.getTitle())
                        .attr("href", vacancy.getUrl());
                element.before(nextCloneElement.outerHtml());

            }
            content = document.html();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            content = "Some exception occurred";
        }


        return content;
    }
    private void updateFile(String s)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(s);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected Document getDocument() throws IOException{
       return Jsoup.parse(filePath,"UTF-8");
    }
}
