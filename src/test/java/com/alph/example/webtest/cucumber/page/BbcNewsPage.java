package com.alph.example.webtest.cucumber.page;

import org.openqa.selenium.WebDriver;

public class BbcNewsPage implements Page {

    private WebDriver webDriver;

    public BbcNewsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void search(String text) {

    }
}
