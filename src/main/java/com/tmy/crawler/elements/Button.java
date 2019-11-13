package com.tmy.crawler.elements;

import com.codeborne.selenide.SelenideElement;

public class Button {

    private SelenideElement webElement;

    public Button(SelenideElement selenideElement) {
        this.webElement = selenideElement;
    }
}
