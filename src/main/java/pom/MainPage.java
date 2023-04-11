package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final By loginToAccount = By.xpath(".//*[contains(text(),'Войти')]");// Локатор кнопки Войти
    private final By personalAccount = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //  Локатор кнопки Личный кабинет
    private final By constructor = By.xpath(".//p[contains(text(),'Конструктор')]"); // Локатор Конструктора
    private final By sauces = By.xpath(".//span[contains(text(),'Соусы')]"); // Локатор соусов
    private final By saucesInDesigner = By.xpath(".//h2[contains(text(),'Соусы')]"); // Локатор соусов в конструкторе

    private final By buns = By.xpath(".//span[contains(text(),'Булки')]"); // Локатор булок
    private final By bunsInDesigner = By.xpath(".//h2[contains(text(),'Булки')]"); // Локатор булок в конструкторе
    private final By fillings = By.xpath(".//span[contains(text(),'Начинки')]"); // Локатор начинок
    private final By fillingsInDesigner = By.xpath(".//h2[contains(text(),'Начинки')]");// Локатор начинок в конструкторе
    private final By stellarBurger = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']"); // Локатор логотипа
    private final By constructBurger = By.xpath("//*[contains(text(),'Соберите бургер')]"); // Локатор надписи соберите бургер
    private final By constructorButton = By.xpath("//*[contains(text(),'Конструктор')]");// Локатор кнопки конструктов в хедере
    private final By enterText = By.xpath(".//h2[contains(text(),'Вход')]"); //текст Вход на странице авторизации

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //переход по ссылке
        driver.get(url);
    }

    public void clickLogin() { //клик на Войти в аккаунт
        driver.findElement(loginToAccount).click();
    }

    public void clickPersonalAccount() { //клик на ЛК
        driver.findElement(personalAccount).click();
    }

    public void clickStellarBurger() {
        driver.findElement(stellarBurger).click();
    }

    public void checkStellarBurger() {
        String actualText = driver.findElement(constructBurger).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected, actualText);
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
        String actualText = driver.findElement(constructBurger).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected, actualText);
    }

    public void checkEnterPageOpen() {
        String actualText = driver.findElement(enterText).getText();
        String expected = "Вход";
        Assert.assertEquals(expected, actualText);
    }

    public void checkSauces() {
        driver.findElement(constructor).click();
        driver.findElement(sauces).click();

        String actualText = driver.findElement(saucesInDesigner).getText();
        String expected = "Соусы";
        Assert.assertEquals(expected, actualText);
    }

    public void checkBuns() {
        driver.findElement(constructor).click();
        driver.findElement(buns);
        String actualText = driver.findElement(bunsInDesigner).getText();
        String expected = "Булки";
        Assert.assertEquals(expected, actualText);
    }

    public void checkFillings() {
        driver.findElement(constructor).click();
        driver.findElement(fillings).click();
        String actualText = driver.findElement(fillingsInDesigner).getText();
        String expected = "Начинки";
        Assert.assertEquals(expected, actualText);
    }


}