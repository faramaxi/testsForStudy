package TestForTestPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AlertsPage {
private final SelenideElement showAlertBox=$x("//input[@value=\"Show alert box\"]");
private final SelenideElement showConfirmBox=$x("//input[@value=\"Show confirm box\"]");
private final SelenideElement showPromptBox=$x("//input[@value=\"Show prompt box\"]");
private final SelenideElement resultAlertField = $x("//p[@id=\"alertexplanation\"]");
private final SelenideElement resultConfirmField=$x("//p[@id=\"confirmreturn\"]");
private final SelenideElement resultPromptField=$x("//p[@id=\"promptreturn\"]");

public void clickAlertBox(){
    showAlertBox.click();
    Selenide.switchTo().alert().accept();
}
public void clickConfirmBoxAccept(){
    showConfirmBox.click();
    Selenide.switchTo().alert().accept();
}
public void clickConfirmBoxDismiss(){
    showConfirmBox.click();
    Selenide.switchTo().alert().dismiss();
}
public void clickShowAlertBox(){
    showPromptBox.click();
    Selenide.switchTo().alert().sendKeys("Hello World");
    Selenide.switchTo().alert().accept();
}
public String getResultPromptBox(){ return resultPromptField.getText();}
public String getResultMessage(){return resultAlertField.getText();}
public boolean getConfirmResultBoolean(){
    String resultText=resultConfirmField.getText();
    return Boolean.parseBoolean(resultText);
}
}