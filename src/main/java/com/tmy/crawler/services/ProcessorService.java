package com.tmy.crawler.services;

import com.tmy.crawler.pages.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@Service
public class ProcessorService {


    @Autowired
    private PageService pageService;

    protected void openBrowser(String url) {
        open(url);
    }


    public void start(String url, String... elements) {
        List<Page> pages = new ArrayList<>();
        openBrowser(url);
        pages.add(new Page(url));
        pages = processSite(pages);

        //savePages
    }

    protected List<Page> processSite(List<Page> pages) {
        int i = 0;
        while (i < pages.size()) {
            Page page = pages.get(i);
            List<Page> newPages = pageService.scanForLinks(page);
            page = pageService.scanPage(page);
            page = pageService.processPage(page);
            i++;
        }

        return pages;
    }


}
