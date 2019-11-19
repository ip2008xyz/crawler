package com.tmy.crawler.services;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.tmy.crawler.elements.Input;
import com.tmy.crawler.pages.Action;
import com.tmy.crawler.pages.Operations;
import com.tmy.crawler.pages.Page;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

@Service
public class PageService {

    @Autowired
    private ComparatorElementService comparatorElementService;

    @Autowired
    private ScannerService scannerService;


    public List<Page> scanForLinks(Page page) {
        List<SelenideElement> elements = scannerService.scanForElements();
        List<Page> pages = new ArrayList<>();
        for (SelenideElement element : elements) {
            pages.add(new Page(element.getAttribute("href")));
        }
        return pages;
    }

    public Page scanPage(Page page) {
        List<SelenideElement> elements = scannerService.scanForElements();
        page.setElements(elements);
        return page;
    }

    public Page processPage(Page page) {
        processInputs(page.getInputs());
        return page;
    }

    private Page processInputs(List<Input> inputs) {
        for (Input input : inputs) {

            Operations<Input> action = new Operations();
            action.setElement(input);
            List<SelenideElement> before = new ArrayList<>($$(By.xpath("//p|//input|//button|//label")));

            action.setAction(Action.CLICK);

            input.getWebElement().contextClick();

            WebDriverRunner.getWebDriver().findElement(By.id("root")).click(); //TODO find correct element

            List<SelenideElement> after = new ArrayList<>($$(By.xpath("//p|//input|//button|//label")));

            List<SelenideElement> changed = comparatorElementService.compareElements(before, after);

            action.setChanges(changed);

        }
        return null;
    }


}
