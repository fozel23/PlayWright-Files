package Ders5_Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;

import static java.lang.Thread.*;

public class Locators_02 {

    public static void main(String[] args) throws InterruptedException {

        // Ekran çözünürlüğünü ayarlama
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        // Playwright ve Browser başlatma
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        // Siteye gitme
        page.navigate("https://demoblaze.com/");
        System.out.println("Page Title: " + page.title());

        // Login butonunu bulma ve tıklama
        Locator loginButton = page.locator("//*[@id='login2']");
        loginButton.waitFor();
        loginButton.click();
        page.locator("//*[@id=\"loginusername\"]").fill("fozel23");git

        page.locator("//*[@id=\"loginpassword\"]").fill("12345");

        page.locator("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]").click();
        Thread.sleep(4000);


        Locator shadowDom = page.locator("div", new Page.LocatorOptions().setHasText("Giriş yap veya kayıt ol")).last();
        System.out.println("shadowDom   " + shadowDom.innerText());



        // Sayfa kapanışı
        page.close();
        browser.close();
        playwright.close();
    }
}

        /* Locate in Shadow DOM
        Locator shadowDom = page.locator("div", new Page.LocatorOptions().setHasText("Giriş yap veya kayıt ol")).last();
        System.out.println("shadowDom   " + shadowDom.innerText());

        // getbyRole
        Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("2. phone number " + phoneNumber.innerText());
        phoneNumber.click();
        phoneNumber.fill("5397157595");

        Thread.sleep(3000);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));*/

