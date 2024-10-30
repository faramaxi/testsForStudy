package TestForTestPages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class FramesPage {



    // Переключение на фрейм "left"
    public void switchToLeftFrame() {
        switchTo().frame("left");    // Затем на первый фрейм "left"
    }

    // Переключение на фрейм "middle"
    public void switchToMiddleFrame() {
        switchTo().frame("middle");    // Затем на второй фрейм "middle"
    }

    // Переключение на фрейм "right"
    public void switchToRightFrame() {
        switchTo().frame("right");    // Затем на третий фрейм "right"
    }
    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }
}
