package Ders3_Locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import java.awt.*;
import java.util.regex.Pattern;

public class BuiltinLocators01 {



    public static void main(String[] args) {
        // Ekran boyutunu al
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        // Playwright başlatma
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Sayfa oluşturma ve boyut ayarlama
        Page page = browser.newPage();
        page.setViewportSize(width, height);

        // Sayfayı açma
        page.navigate("http://getir.com");
        System.out.println("title " + page.title());

        // getByText: "Giriş yap veya kayıt ol" metnini al
        Locator loginText = page.getByText("Giriş yap veya kayıt ol");
        System.out.println("1. Text " + loginText.innerText());

        // Shadow DOM içindeki öğeyi bulma
        Locator shadowDom = page.locator("div", new Page.LocatorOptions().setHasText("Giriş yap veya kayıt ol")).last();
        System.out.println("shadowDom   " + shadowDom.innerText());

        // getByRole: "Telefon Numarası" metniyle textbox'ı al
        Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("2. phone number " + phoneNumber.innerText());

        // Telefon numarasını doldur
        phoneNumber.click();
        phoneNumber.fill("5397777777");

        // Telefon numarası ile devam et butonuna tıklama
       Locator continueButton = page.getByText("Telefon numarası ile devam et");
        continueButton.click();

        Locator nameInputByPlaceholder = page.getByPlaceholder("Ad Soyad");
        nameInputByPlaceholder.click();
        nameInputByPlaceholder.fill("Ahmet Karsı");

        Locator emailInputByPlaceholder = page.getByPlaceholder("E-Posta");
        emailInputByPlaceholder.click();
        emailInputByPlaceholder.fill("abfdclmnkpt12@hotmail.com");

        Locator kayitOlByText = page.locator("button").nth(10);
        kayitOlByText.click();
        Locator closeButton = page.locator("[data-testid='icon']");
        closeButton.click();







       // Locator logoByAltText = page.locator("img").getByAltText("Su & İçecek");
        //logoByAltText.click();
        // Kapatma ikonu (SVG) butonuna tıklama
       /* Locator closeIcon = page.locator("svg[data-testid='icon'][name='close']");
        closeIcon.waitFor(new Locator.WaitForOptions().setTimeout(5000));  // Öğenin varlığını kontrol et
        closeIcon.click();*/




         //Sayfa ve browser'ı kapatmadan önce tüm işlemlerin tamamlandığından emin ol
        page.close();
        browser.close();
        playwright.close();


    }
}
