package com.tmy.crawler.services;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComparatorElementService {
    public List<SelenideElement> compareElements(List<SelenideElement> before, List<SelenideElement> after) {
        List<SelenideElement> changed = new ArrayList<>();

        for (SelenideElement element : after) {
            if (before.contains(element)) {
                System.out.println("in before " + element);
            } else {
                System.out.println(element);
            }

        }

        return changed;

    }

}
