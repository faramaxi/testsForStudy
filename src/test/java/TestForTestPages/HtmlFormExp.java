package TestForTestPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class HtmlFormExp {

    private SelenideElement usernameField = $x("//input[@name=\"username\"]");
    private SelenideElement passwordField = $x("//input[@name=\"password\"]");
    private SelenideElement commentField = $x("//tr//textarea[@name=\"comments\"]");
    private SelenideElement fileInput = $x("//input[@name=\"filename\"]");
    private SelenideElement checkbox1 = $x("//input[@name='checkboxes[]'][@value='cb1']");
    private SelenideElement checkbox2 = $x("//input[@name='checkboxes[]'][@value='cb2']");
    private SelenideElement checkbox3 = $x("//input[@name='checkboxes[]'][@value='cb3']");
    private SelenideElement radio1 = $x("//input[@name='radioval'][@value='rd1']");
    private SelenideElement radio2 = $x("//input[@name='radioval'][@value='rd2']");
    private SelenideElement radio3 = $x("//input[@name='radioval'][@value='rd3']");

    private SelenideElement multipleSelect = $x("//select[@name=\"multipleselect[]\"]");
    private SelenideElement dropdown = $x("//select[@name=\"dropdown\"]");
    private SelenideElement submitButton = $x("//input[@value=\"submit\"]");
    private SelenideElement cancelButton = $x("//input[@value=\"cancel\"]");

    public void setUserNameField(){
        usernameField.sendKeys("faramaxi");
    }
    public void setUserPassordField(){
        passwordField.sendKeys("aswert123");
    }
    public void setCommentField(){
        commentField.setValue("Hello World");
    }
    public void setFileInput (){
        fileInput.setValue("C:\\Users\\Max\\Desktop\\Smiley.svg.png");
    }
    // Список всех чекбоксов
    private List<SelenideElement> allCheckboxes = List.of(checkbox1, checkbox2, checkbox3);

    // Геттер для получения всех чекбоксов
    public List<SelenideElement> getAllCheckboxes() {
        return allCheckboxes;
    }

    // Метод для выбора чекбоксов по индексам
    public void selectCheckboxesByIndices(int... indices) {
        // Снять галочки со всех чекбоксов
        for (SelenideElement checkbox : allCheckboxes) {
            if (checkbox.isSelected()) {
                checkbox.click(); // Снимаем галочку, если чекбокс выбран
            }
        }

        // Выбрать чекбоксы по переданным индексам
        for (int index : indices) {
            SelenideElement checkbox = allCheckboxes.get(index);
            if (!checkbox.isSelected()) {
                checkbox.click(); // Выбираем чекбокс по индексу, если он еще не выбран
            }
        }
    }
    public void selectRadioBtn1(){
        radio1.click();
    }
    public void selectRadioBtn2(){
        radio2.click();
    }
    public void selectRadioBtn3(){
        radio3.click();
    }
    public void setMultipleSelect(int... indices){
        Select select_multiple=new Select(multipleSelect);
        select_multiple.deselectAll();
     for (int index:indices){
         select_multiple.selectByIndex(index);
     }
    }
    public void setDropdown(int... indices){
        Select select_dropdown=new Select(dropdown);
        for (int index:indices){
            select_dropdown.selectByIndex(index);
        }
    }
    public void clickSubmitBtn(){
        submitButton.click();
    }
    public void clickCancelBtn(){
        cancelButton.click();
    }
};

