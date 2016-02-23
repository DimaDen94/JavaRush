package com.javarush.test.level28.lesson15.big01.vo;

/**
 * Created by Dmitry on 20.02.2016.
 */
public class Vacancy
{
    String title, salary, city, companyName, siteName, url;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSalary()
    {
        return salary;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getSiteName()
    {
        return siteName;
    }

    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Vacancy vacancy = (Vacancy) o;

        if (city != null)
            if(!city.equals(vacancy.city))
                return false;
        if (companyName != null)
            if(!companyName.equals(vacancy.companyName))
                return false;
        if (salary != null)
            if(!salary.equals(vacancy.salary))
                return false;
        if (siteName != null)
            if(!siteName.equals(vacancy.siteName))
                return false;
        if (title != null)
            if(!title.equals(vacancy.title))
                return false;
        if (url != null)
            if(!url.equals(vacancy.url))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
