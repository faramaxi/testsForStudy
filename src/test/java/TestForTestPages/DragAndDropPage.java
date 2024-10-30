package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class DragAndDropPage {
    private final SelenideElement dragElement1= $x("//div[@id=\"draggable1\"]");
    private final SelenideElement dragElement2= $x("//div[@id=\"draggable2\"]");
    private final SelenideElement dropTable1= $x("//div[@id=\"droppable1\"]");
    private final SelenideElement dropTable2= $x("//div[@id=\"droppable2\"]");
public void dragFirstElementToDropArea(){
    actions().dragAndDrop(dragElement1,dropTable1).perform();
    dropTable1.shouldHave(text("Dropped!"));
}
    public void dragSecondElementToDropArea(){
    actions().dragAndDrop(dragElement2,dropTable2).perform();
    dropTable2.shouldHave(text("Dropped!"));
    }




}
