package userinyerface.framework.browser.cookie;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import userinyerface.framework.browser.Browser;

import java.util.Set;

public class CookieManager {
    private static WebDriver driver = Browser.BROWSER.getDriver();

    public static void addCookie (String name, String value) {
        addCookie(new Cookie(name, value));
    }
    public static void addCookie (Cookie cookie) {
        driver.manage().addCookie(cookie);
    }
    public static void deleteCookie (Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }
    public static void deleteAllCookies () {
        driver.manage().deleteAllCookies();
    }
    public static void deleteCookieNamed (String name) {
        driver.manage().deleteCookieNamed(name);
    }
    public static Set<Cookie> getAllCookies () {
        return driver.manage().getCookies();
    }
    public static Cookie getCookieNamed (String name) {
       return driver.manage().getCookieNamed(name);
    }
    public static int sizeCookies () {
        return getAllCookies().size();
    }
    public static boolean setNewNValue(String name, String newValue) {
        for (Cookie currCookie : getAllCookies()) {
            if (name.equals(currCookie.getName())) {
              deleteCookieNamed(name);
              addCookie(name, newValue);
              return true;
            }
        } return false;
    }
    public static boolean cookieIsDelete(String name) {
        for (Cookie currCookie : getAllCookies()) {
            if (name.equals(currCookie.getName())) {
                return false;
            }
        } return true;
    }
}
