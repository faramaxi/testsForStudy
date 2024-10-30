package TestForTestPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class InputPage {
    //локатор для поля ввода
    private final SelenideElement inputField = $x("//input[@id=\"numentry\"]");
    //локатор для элемента с результатом
    private final SelenideElement resultMessage = $x("//div//p[@id=\"message\"]");

    // метод для ввода текста и нажатия ENTER
    public void enterText(String text) {
        inputField.click();
        inputField.setValue(text).sendKeys(Keys.ENTER);
    }
    // Метод для проверки текста в элементе с результатом
    public String getResultMessage(){
        return resultMessage.getText(); //возвращает текст элемента
    }
}

