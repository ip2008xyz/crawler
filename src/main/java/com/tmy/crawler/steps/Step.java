package com.tmy.crawler.steps;

import com.codeborne.selenide.SelenideElement;
import com.tmy.crawler.pages.Page;
import lombok.Data;

import java.util.List;

@Data
public class Step {
    private Page page;
    private List<SelenideElement> elements;
}
