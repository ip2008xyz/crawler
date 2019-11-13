package com.tmy.crawler.pages;

import com.codeborne.selenide.SelenideElement;
import com.tmy.crawler.elements.Input;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page {


    private String url;
    private List<SelenideElement> elements = new ArrayList<>();

    public Page(String url) {
        this.url = url;
    }

    public List<Input> getInputs() {
        List<Input> inputs = new ArrayList<>();
        for (SelenideElement selenideElement : elements) {
            //if(selenideElement.has(Condition.type("input")))
            Input input = new Input(selenideElement);
            inputs.add(input);
        }
        return inputs;
    }

}
