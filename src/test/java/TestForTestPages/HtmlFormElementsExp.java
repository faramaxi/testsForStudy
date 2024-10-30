package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
public class HtmlFormElementsExp {
    private SelenideElement colorPicker= $x("//input[@id=\"colour-picker\"]");
    private SelenideElement dateField= $x("//input[@id=\"date-picker\"]");
    private SelenideElement localDataTimeField= $x("//input[@id=\"date-time-picker\"]");
    private SelenideElement emailField= $x("//input[@id=\"email-field\"]");
    private SelenideElement monthField= $x("//input[@id=\"month-field\"]");
    private SelenideElement numberField=$x("//input[@id=\"number-field\"]");
    private SelenideElement submitBtn=$x("//input[@name='submitbutton']");
    private SelenideElement resetBtn=$x("//input[type='reset']");

    public HtmlFormElementsExp selectColor(String colorHex) {
        colorPicker.setValue(colorHex);
        return this;
    }
    public HtmlFormElementsExp setDate(String date) {
        dateField.setValue(date);
        return this;
    }

    public HtmlFormElementsExp setLocalDateTime(String date, String time) {
        localDataTimeField.setValue(date).pressTab().sendKeys(time);
        return this;
    }

    public HtmlFormElementsExp setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public HtmlFormElementsExp setMonth(Integer month, String year) {
        monthField.setValue(String.valueOf(month)).pressTab().sendKeys(year);
        return this;
    }

    public HtmlFormElementsExp setNumber(String number) {
        numberField.setValue(number);
        return this;
    }

    public void submitForm() {
        submitBtn.shouldBe(visible).click();
    }
    public void resetForm(){
        resetBtn.click();
}

}
