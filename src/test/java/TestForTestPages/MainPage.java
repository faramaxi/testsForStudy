package TestForTestPages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement webDriverExpPage=$x("//li//a[@id=\"webdriverexamplepage\"]");
    private final SelenideElement tablePage=$x("//li//a[@id=\"tablestest\"]");
    private final SelenideElement alertsPage=$x("//a[@id=\"alerttest\"]");
    private final SelenideElement framesPage=$x("//a[@id=\"framestest\"]");
    private final SelenideElement iFramesPage=$x("//a[@id=\"iframestest\"]");
    private final SelenideElement htmlFormExp=$x("//ul//a[@id=\"htmlformtest\"]");
    private final SelenideElement htmlFormElementsExp=$x("//ul//a[@id=\"html5formtest\"]");
    private final SelenideElement ajaxPage=$x("//a[@id=\"basicajaxtest\"]");
    private final SelenideElement dragAndDrop=$x("//a[@id=\"useractionstest\"]");
    private final SelenideElement basicAuthPage=$x("//a[@id=\"basicauth\"]");
    private final SelenideElement simpleDynamicBtn=$x("//a[@id=\"button01\"]");
    private final SelenideElement clientServerInputPage=$x("//a[@id=\"inputvalidation\"]");
    private final SelenideElement calculator=$x("//a[@id=\"calculatetest\"]");


    public MainPage(String url){
        Selenide.open(url);
    }
    public void clickWebDriverExp(){
    webDriverExpPage.click();
}
    public void clickTablePage(){
        tablePage.click();
    }
    public void clickAlertsPage(){
        alertsPage.click();
    }
    public void clickFlamesPage(){framesPage.click();}
    public void clickIFramesPage(){iFramesPage.click();}
    public void clickHtmlFormExp(){htmlFormExp.click();}
    public void clickHtmlFormElementsExp(){htmlFormElementsExp.click();}
    public void clickAjaxPage(){ajaxPage.click();}
    public void clickDragAndDropPage(){dragAndDrop.click();}
    public void clickBasicAuthPage(){basicAuthPage.click();}
    public void clickSimpleDynamicBtn(){simpleDynamicBtn.click();}
    public void clickClientServerInputPage(){clientServerInputPage.click();}
    public void clickCalculator(){calculator.click();}

}
