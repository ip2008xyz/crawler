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
    private List<Operations> actions = new ArrayList<>();

    public Page(String url) {
        this.url = url;
    }

    public List<Input> getInputs() {
        List<Input> inputs = new ArrayList<>();
        for (SelenideElement selenideElement : elements) {
            System.out.println(selenideElement.getTagName());
            switch (selenideElement.getTagName()) {
                case "input":
                    Input input = new Input(selenideElement);
                    inputs.add(input);
                    break;

            }


        }
        return inputs;
    }

}
