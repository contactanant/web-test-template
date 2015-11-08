package com.alph.example.webtest.selenium;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.getenv;

public class WebDriverConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverConfig.class);
    private WebDriver webDriver;
    private WebDriverFactory webDriverFactory;
    private final Thread DRIVER_SHUTDOWN_THREAD = shutdownThread();

    public WebDriverConfig() {
        Runtime.getRuntime().addShutdownHook(DRIVER_SHUTDOWN_THREAD);
        //TODO: dependency injection here
        webDriverFactory = new WebDriverFactory();
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = createWebDriverInstance();
        }
        return webDriver;
    }

    public void resetBrowser() {
        clearCookies();
        closeAllTabsAndChildWindowsExceptMain();
        webDriverFactory.resetBrowserWindowSize(webDriver);
    }

    public WebDriver createWebDriverInstance() {
        BrowserType browser = getBrowserType();
        return webDriverFactory.createWebDriver(browser);
    }

    public BrowserType getBrowserType() {
        String browser = System.getProperty("TEST_BROWSER", getenv("TEST_BROWSER"));
        if (browser != null) {
            LOGGER.info("Setting browser as {}", browser);
        }
        return browser != null ? BrowserType.valueOf(browser) : null;
    }

    private void clearCookies() {
        if (webDriver != null) {
            webDriver.manage().deleteAllCookies();
        }
    }

    private void closeAllTabsAndChildWindowsExceptMain() {
        if (webDriver != null) {
            String originalHandle = webDriver.getWindowHandle();
            for (String handle : webDriver.getWindowHandles()) {
                if (!handle.equals(originalHandle)) {
                    webDriver.switchTo().window(handle);
                    webDriver.close();
                }
            }

            webDriver.switchTo().window(originalHandle);
        }
    }

    public void saveSourceAndScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        //TODO store the image and source as scenario name so it is easy to debug later
        scenario.embed(screenshot, "image/png");
    }

    private Thread shutdownThread() {
        return new Thread() {
            @Override
            public void run() {
                try {
                    webDriver.quit();
                } catch (Exception e) {
                    System.out.println("Could not quit webDriver gracefully.");
                }
            }
        };
    }
}
