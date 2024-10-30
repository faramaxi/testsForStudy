package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SimpleCalculator {
    private final SelenideElement firstNumber= $x("//input[@id=\"number1\"]");
    private final SelenideElement secondNumber= $x("//input[@id=\"number2\"]");
    private final SelenideElement function=$x("//select[@id=\"function\"]");
    private final SelenideElement submitBtn=$x("//input[@id=\"calculate\"]");
    private final SelenideElement resultField=$x("//span[@id=\"answer\"]");

public void setNumbersAndOperations(String num1, String num2, String operation){
    firstNumber.shouldBe(visible).setValue(num1);
    secondNumber.shouldBe(visible).setValue(num2);
    function.selectOption(operation);}
public void clickCalculate(){
    submitBtn.shouldBe(visible).click();}
public String getResult(){
    return resultField.shouldBe(visible).getText();
}
}
