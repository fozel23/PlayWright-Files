package Ders4_Ornek1;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

public class Ornek_01 {

        public static void main(String[] args) {
                // Playwright başlatılıyor
                try (Playwright playwright = Playwright.create()) {
                        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                        BrowserContext context = browser.newContext();
                        Page page = context.newPage();

                        // Google ana sayfasına git
                        page.navigate("https://www.demoblaze.com");





                        // XPath ile arama çubuğunu bul ve "Playwright Java" yaz
                        Locator searchBox = page.locator("h5M12e;input:d3sQLd;blur:jI3wzf");
                        Thread.sleep(3000);


                        // Google'ın arama çubuğu
                        searchBox.fill("Playwright Java");
                        searchBox.press("Enter");

                        // Sonuçların yüklendiğinden emin olmak için bekle
                        page.waitForLoadState(LoadState.NETWORKIDLE);

                        // Sayfa başlığını kontrol et
                        String title = page.title();
                        System.out.println("Sayfa Başlığı: " + title);

                        if (title.toLowerCase().contains("playwright java")) {
                                System.out.println("Test Başarılı!");
                        } else {
                                System.out.println("Test Başarısız!");
                        }

                        // Tarayıcıyı kapat
                        browser.close();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
}
