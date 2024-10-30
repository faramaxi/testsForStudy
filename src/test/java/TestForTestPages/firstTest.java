package TestForTestPages;

import Core.BaseSeleniumTest;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class firstTest extends BaseSeleniumTest {

    private final static String BASE_URL="https://testpages.eviltester.com/styled/index.html";
    private final static String TEST_INPUT="1";
    private static final String EXPECTED_RESULT = "one";
    private static final String EXPECTED_HEADER_FIRST = "Name";
    private static final String EXPECTED_HEADER_SECOND = "Amount";
    private static final String EXPECTED_RESULT_ALERT="You triggered and handled the alert dialog";
    private static final String EXPECTED_RESULT_PROMPT="Hello World";
    private HtmlFormElementsExp formPage = new HtmlFormElementsExp();

@Test
    public void testInputField(){
    //открывает главную страницу
    MainPage mainPage=new MainPage(BASE_URL);
    // Переходим на другую страницу
    mainPage.clickWebDriverExp();
    InputPage inputPage=new InputPage();
    // Вводим текст в поле ввода
    inputPage.enterText(TEST_INPUT);
    // Проверка, что поле ввода содержит введённый текст
    String actualResult= inputPage.getResultMessage();
    assertEquals("Проверка текста результата",EXPECTED_RESULT,actualResult);
}
@Test
    public void testTablePage(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickTablePage();
    TablePage tablePage=new TablePage();
    String actualResultFirstHeader= tablePage.getHeaderFirst();
    assertEquals("Проверка результата",EXPECTED_HEADER_FIRST,actualResultFirstHeader);
    String actualResultSecondHeader= tablePage.getHeaderSecond();
    assertEquals("Проверка результата",EXPECTED_HEADER_SECOND,actualResultSecondHeader);
}
@Test
    public void testAlertsShowBoxPage(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickAlertsPage();
    AlertsPage alertsPage= new AlertsPage();
    alertsPage.clickAlertBox();
    String actualResult=alertsPage.getResultMessage();
    assertEquals("Проверка результата после нажатия на OK",EXPECTED_RESULT_ALERT,actualResult);
}
@Test
    public void testAlertsConfirmBoxPageAccept(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickAlertsPage();
    AlertsPage alertsPage= new AlertsPage();
    alertsPage.clickConfirmBoxAccept();
    boolean actualResult= alertsPage.getConfirmResultBoolean();
    assertTrue("Ожидается значение true после нажатия OK",actualResult);
}
@Test
    public void testAlertsConfirmBoxPageDismiss() {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.clickAlertsPage();
        AlertsPage alertsPage = new AlertsPage();
        alertsPage.clickConfirmBoxDismiss(); // Нажимаем "Cancel" в алерте
        boolean actualResult = alertsPage.getConfirmResultBoolean();
        assertFalse("Ожидается значение false после нажатия Cancel", actualResult);
    }
@Test
    public void testAlertsPromptBoxPage(){
    MainPage mainPage = new MainPage(BASE_URL);
    mainPage.clickAlertsPage();
    AlertsPage alertsPage = new AlertsPage();
    alertsPage.clickShowAlertBox();
    String actualResultPrompt=alertsPage.getResultPromptBox();
    assertEquals("Проверка результата ввода",actualResultPrompt,EXPECTED_RESULT_PROMPT);
}
@Test
    public void testLeftFrame(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickFlamesPage();
    switchTo ().frame("left");
    $$("li").get(0).shouldHave(text("Left List Item 0"));
    $$("li").get(1).shouldHave(text("Left List Item 1"));
    $$("li").get(2).shouldHave(text("Left List Item 2"));
    switchTo().defaultContent();

}
@Test
    public void testFrameSwitching(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickFlamesPage();
    FramesPage framesPage= new FramesPage();
    framesPage.switchToLeftFrame();
    $("li").shouldHave(text("Left List Item 0"));
    framesPage.switchToDefaultContent();
    framesPage.switchToMiddleFrame();
    $("li").shouldHave(text("Middle List Item 0"));
    framesPage.switchToDefaultContent();
    framesPage.switchToRightFrame();
    $("li").shouldHave(text("Right List Item 0"));
    framesPage.switchToDefaultContent();
}
@Test
    public void testElementsNotAccessibleOutsideFrames() {
        MainPage mainPage=new MainPage(BASE_URL);
        mainPage.clickFlamesPage();
        FramesPage framesPage= new FramesPage();
        framesPage.switchToLeftFrame();
        boolean isElementOutsideFrameVisible = $$("li").filter(visible).isEmpty();
        assertEquals(true,isElementOutsideFrameVisible);
        framesPage.switchToLeftFrame();
        $$("li").get(0).shouldHave(text("Left List Item 0"));
        framesPage.switchToDefaultContent();
        framesPage.switchToRightFrame();
        $$("li").get(0).shouldHave(text("Middle List Item 0"));
        framesPage.switchToDefaultContent();
       framesPage.switchToRightFrame();
        $$("li").get(0).shouldHave(text("Right List Item 0"));
       framesPage.switchToDefaultContent();
    }
@Test
    public void testIFrameVisibility(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickIFramesPage();
    iFramePage iframepage=new iFramePage();
    iframepage.iFrameVisibility();
}
@Test
    public void htmlFormExp(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickHtmlFormExp();
    HtmlFormExp htmlFormExp=new HtmlFormExp();
    htmlFormExp.setUserNameField();
    htmlFormExp.setUserPassordField();
    htmlFormExp.setCommentField();
    htmlFormExp.setFileInput();
    htmlFormExp.selectCheckboxesByIndices(0,1);
    htmlFormExp.selectRadioBtn3();
    htmlFormExp.setMultipleSelect(1 ,0);
    htmlFormExp.setDropdown(3);
}
@Test
    public void htmlFormElementsExp(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickHtmlFormElementsExp();
    formPage.selectColor("#F20707")
            .setDate("10-10-2024")
            .setLocalDateTime("10-10-2020","12:00")
            .setEmail("test@gmail.com")
            .setMonth(Integer.valueOf("10"),"2020")
            .setNumber("25");
    formPage.submitForm();
}
@Test
    public void testAjax() throws InterruptedException {
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickAjaxPage();
    AjaxPage ajaxPage= new AjaxPage();
    ajaxPage.setCategoryField(2);
    ajaxPage.setLanguageField(2);
    ajaxPage.clickSubmitBtn();
}
@Test
    public void testDragAndDrop(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickDragAndDropPage();
    DragAndDropPage dragAndDropPage=new DragAndDropPage();
    dragAndDropPage.dragFirstElementToDropArea();
    dragAndDropPage.dragSecondElementToDropArea();

}
@Test
    public void testBasicAuthPage() throws InterruptedException {
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickBasicAuthPage();
    BasicAuthPage basicAuthPage=new BasicAuthPage();
    basicAuthPage.clickBasicAuthPage();
}
@Test
    public void testSimpleDynamicBtn() throws InterruptedException {
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickSimpleDynamicBtn();
    SimpleDynamicBtn simpleDynamicBtn=new SimpleDynamicBtn();
    simpleDynamicBtn.clickAllButtons();
    String actualMessage= simpleDynamicBtn.getMessageText();
    String expectedMessage= "All Buttons Clicked";
    assertEquals(expectedMessage,actualMessage);
}
@Test
    public void testClienServerInputPage(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickClientServerInputPage();
    ClientServerInputPage clientServerInputPage=new ClientServerInputPage();
    clientServerInputPage.setFirstNameField();
    clientServerInputPage.setLastNameField();
    clientServerInputPage.setAgeField();
    String country ="Belarus";
    clientServerInputPage.setCountryField(country);
    clientServerInputPage.setNotesField();
   clientServerInputPage.clickSubmitBtn();
}
@Test
    public void testCalculator(){
    MainPage mainPage=new MainPage(BASE_URL);
    mainPage.clickCalculator();
    SimpleCalculator calculator=new SimpleCalculator();
    calculator.setNumbersAndOperations("10","10","times");
    calculator.clickCalculate();
    String expected ="100";
    String actual= calculator.getResult();
    assertEquals("Результат умножения некорректный",expected,actual);
    int i=1;
}


}
