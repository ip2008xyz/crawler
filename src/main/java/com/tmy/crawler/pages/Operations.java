package com.tmy.crawler.pages;


import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import javax.swing.*;
import java.util.List;

@Data
public class Operations<T> {
    private T element;
    private List<SelenideElement> changes;
    private Action action;
}
