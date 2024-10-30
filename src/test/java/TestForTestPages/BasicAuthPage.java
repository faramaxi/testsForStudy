package TestForTestPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class BasicAuthPage {
private final SelenideElement basicAuthPage=$x("//a[text()='Basic Auth Protected Page']");

    public void clickBasicAuthPage() {
        // Формируем URL с логином и паролем
        String urlWithCredentials = "https://authorized:password001@testpages.eviltester.com/styled/auth/basic-auth-test.html";

        // Переход на страницу с базовой авторизацией
        Selenide.open(urlWithCredentials);
        basicAuthPage.click();
    }

}
