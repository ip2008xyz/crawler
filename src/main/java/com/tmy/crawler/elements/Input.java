package com.tmy.crawler.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

@Data
public class Input {

    private SelenideElement webElement;

    public Input(SelenideElement selenideElement) {
        this.webElement = selenideElement;
    }

}
