package com.alph.example.webtest.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);
    public static final int DEFAULT_BROWSER_WIDTH = 1920;
    public static final int DEFAULT_BROWSER_HEIGHT = 1080;

    public WebDriver createWebDriver(BrowserType browser) {
        switch(browser) {
            case FIREFOX:
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                FirefoxDriver webDriverFirefox = new FirefoxDriver(firefoxProfile);
                resetBrowserWindowSize(webDriverFirefox);
                return webDriverFirefox;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
                DesiredCapabilities desiredCapabilitiesChrome = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                desiredCapabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, options);
                ChromeDriver webDriverChrome = new ChromeDriver(desiredCapabilitiesChrome);
                resetBrowserWindowSize(webDriverChrome);
                return webDriverChrome;
            default:
                LOGGER.info("No browser choice has been specified, setting browser to {}", browser);
                DesiredCapabilities desiredCapabilitiesPhantom = DesiredCapabilities.phantomjs();
                desiredCapabilitiesPhantom.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
                desiredCapabilitiesPhantom.setJavascriptEnabled(true);
                desiredCapabilitiesPhantom.setPlatform(org.openqa.selenium.Platform.ANY);
                WebDriver webDriver = new PhantomJSDriver(desiredCapabilitiesPhantom);
                resetBrowserWindowSize(webDriver);
                return webDriver;
        }
    }

    public void resetBrowserWindowSize(WebDriver webDriver) {
        if (webDriver != null) {
            webDriver.manage().window().setSize(new Dimension(DEFAULT_BROWSER_WIDTH, DEFAULT_BROWSER_HEIGHT));
        }
    }
}
