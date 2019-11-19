package com.tmy.crawler.services;


import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

@Service
public class ScannerService {

    //TODO use config
    private List<String> elementsToScanFor = Arrays.asList("input", "button");

    public List<SelenideElement> scanForLinks() {
        List<SelenideElement> elements = new ArrayList<>();
        for (SelenideElement element : $$("a")) {
            elements.add(element);
        }
        return elements;
    }

    public List<SelenideElement> scanForElements() {
        List<SelenideElement> elements = new ArrayList<>();
        for (String elementName : elementsToScanFor) {
            for (SelenideElement element : $$(elementName)) {
                elements.add(element);
            }
        }


        return elements;
    }
}
