package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
public class TablePage {
//*локатор для Заголовка 1 столбца
private final SelenideElement columnHeaderFirst= $x("//tr/th[1]");
//*локатор для Заголовка 2 столбца
private final SelenideElement columnHeaderSecond= $x("//tr/th[2]");

    public String getHeaderFirst(){ return columnHeaderFirst.getText(); //возвращает текст Заголовка 1 столбца
    }
    public String getHeaderSecond() { return columnHeaderSecond.getText(); //возвращает текст Заголовка 2 столбца
    }
}