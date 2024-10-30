package TestForTestPages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$x;

public class iFramePage {
    public void iFrameVisibility (){
        $x("//h1[text()='iFrames Example']").shouldBe(Condition.visible);
    }

}
