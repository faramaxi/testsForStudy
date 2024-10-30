package TestForTestPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$x;

public class AjaxPage {
    private final SelenideElement categoryField=$x("//select[@id=\"combo1\"]");
    private final SelenideElement languageField=$x("//select[@id=\"combo2\"]");
    private final SelenideElement submitBtn=$x("//input[@name=\"submitbutton\"]");
public void setCategoryField(int... indices) {
    Select select_categoryField = new Select(categoryField);
    for (int index : indices) {
        select_categoryField.selectByIndex(index);
    }
}
public void setLanguageField ( int...indices)throws InterruptedException{
    Thread.sleep(5000);
    Select select_languageField = new Select(languageField);
    for (int index : indices) {
        select_languageField.selectByIndex(index);
    }
}
public void clickSubmitBtn(){
    submitBtn.click();
}
}
