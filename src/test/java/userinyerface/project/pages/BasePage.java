package userinyerface.project.pages;


import userinyerface.framework.browser.Browser;

public class BasePage {
    protected Browser browser;

    public BasePage() {
        this.browser = Browser.BROWSER;
    }
}
