package com.tmy.crawler.services;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.tmy.crawler.elements.Input;
import com.tmy.crawler.pages.Page;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

@Service
public class PageService {

    @Autowired
    private ComparatorElementService comparatorElementService;

    @Autowired
    private ScannerService scannerService;


    public Page scanPage(String url) {
        Page page = new Page(url);

        List<SelenideElement> elements = scannerService.scanCurrentPage();

        page.setElements(elements);

        return page;
    }

    public Page processPage(Page page) {

        processInputs(page.getInputs());

        return page;
    }

    protected Page processInputs(List<Input> inputs) {
        for (Input input : inputs) {
            List<SelenideElement> before = $$(By.xpath("//p|//input|//button|//label"));

            for (SelenideElement element : before) {
                System.out.println(element);
            }

            input.getWebElement().contextClick();
            WebDriverRunner.getWebDriver().findElement(By.id("root")).click();
            List<SelenideElement> after = $$(By.xpath("//p|//input|//button|//label"));

            List<SelenideElement> changed = comparatorElementService.compareElements(before, after);


        }
        return null;
    }


}
