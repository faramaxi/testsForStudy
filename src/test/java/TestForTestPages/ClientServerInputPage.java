package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClientServerInputPage {
    public final SelenideElement firstNameField=$x("//input[@name=\"firstname\"]");
    public final SelenideElement lastNameField=$x("//input[@name=\"surname\"]");
    public final SelenideElement ageField=$x("//input[@id=\"age\"]");
    public final SelenideElement countryField=$x("//select[@id=\"country\"]");
    public final SelenideElement notesField=$x("//textarea[@id=\"notes\"]");
    public final SelenideElement submitBtn=$x("//input[@type=\"submit\"]");

    public void setFirstNameField(){firstNameField.sendKeys("Maksym");}
    public void setLastNameField(){lastNameField.sendKeys("Korniiets The Best");}
    public void setAgeField(){ageField.sendKeys("29");}
    public void setCountryField(String country){
        countryField.selectOption(country);}
    public void setNotesField(){notesField.sendKeys("Hello World");}
    public void clickSubmitBtn(){submitBtn.click();}



}
