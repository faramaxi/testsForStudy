package TestForTestPages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SimpleDynamicBtn {
    private final SelenideElement btnStart = $x("//button[@id='button00']");
    private final SelenideElement btnOne = $x("//button[@id='button01']");
    private final SelenideElement btnTwo = $x("//button[@id='button02']");
    private final SelenideElement btnThree = $x("//button[@id='button03']");
    private final SelenideElement resultMessage = $x("//p[@id='buttonmessage']");
    public void clickAllButtons() {
        btnStart.shouldBe(visible).click();
        btnOne.shouldBe(visible).click();
        btnTwo.shouldBe(visible).click();
        btnThree.shouldBe(visible, Duration.ofSeconds(5)).click();
    }
    public String getMessageText() {
        return resultMessage.shouldBe(visible).getText();
    }
}
