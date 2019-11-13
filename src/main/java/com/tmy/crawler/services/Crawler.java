package com.tmy.crawler.services;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.tmy.crawler.elements.Input;
import com.tmy.crawler.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Service
public class Crawler {


    @Autowired
    private PageService pageService;

    protected void openBrowser(String url) {
        open(url);
    }


    public void start(String url, String... elements) {
        openBrowser(url);
        Page page = pageService.scanPage(url);
        page = pageService.processPage(page);

    }



}
