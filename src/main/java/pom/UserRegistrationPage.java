package pom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPage {
    private final String url = "https://stellarburgers.nomoreparties.site/"; // url входа
    private final By loginAccount = By.xpath(".//*[contains(text(),'Войти')]");// Локатор кнопки Войти
    private final By personalAccount = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); // Локатор личного кабинера
    private final By registration = By.xpath(".//a[contains(text(),'Зарегистрироваться')]"); // Локатор Зарегистрироваться
    private final By userName = By.xpath("//label[contains(text(),'Имя')]/../input"); // Локатор поля Имя
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input"); // Локатор поля почта
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input"); // Локатор поля пароль
    private final By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]"); //Локатор кнопки зарегистрироваться
    private final By errorText = By.xpath(".//p[@class='input__error text_type_main-default']"); // Локатор текста ошибки Неверный пароль
    private final By loginEmail = By.xpath(".//input[@name='name']"); // Локатор поля Логин
    private final By loginPassword = By.xpath(".//input[@name='Пароль']"); //Локатор поля пароль
    private final By enter = By.xpath(".//button[contains(text(),'Войти')]"); //Локатор кнопки Войти
    private final By updatePassword = By.xpath(".//a[contains(text(),'Восстановить пароль')]"); // Локатор кнопки восстановить пароль
    private final By emailUpdate = By.xpath("//*[contains(text(),'Email')]/../input"); // Локатор поля почты при восстановлении пароля
    private final By recover = By.xpath(".//button[contains(text(),'Восстановить')]");// Локатор кнопки Восстановить
    private final By changeEmail = By.xpath("//input[@name='Введите новый пароль']");// Локатор поля ввода нового пароля ИЗМЕНИТЬ
    private final By code = By.xpath("//input[@name='name']"); // Локатор поля ввода кода из письма ИЗМЕНИТЬ
    private final By save = By.xpath(".//button[contains(text(),'Сохранить')]"); // Локатор кнопки Сохранить
    private final By logOutButton = By.xpath("//button[contains(text(),'Выход')]");
    private final By centralLoginButton = By.xpath("//h2[contains(text(),'Вход')]");
    private final String randomName = RandomStringUtils.randomAlphanumeric(8); // Рандомное имя пользователя
    private final String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@yandex.ru"; // Рандомный email пользователя
    private final String randomPassword = RandomStringUtils.randomAlphanumeric(10); // Рандомный пароль пользователя

    private WebDriver driver;

    public UserRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //переход по ссылке
        driver.get(url);
    }

    public void clickLogin() { //клик на Cоусы
        driver.findElement(loginAccount).click();
    }

    public void clickPersonalAccount() { //клик на Личный кабинет
        driver.findElement(personalAccount).click();
    }

    public void checkRegistration() throws InterruptedException {
        driver.findElement(registration).click();
        driver.findElement(userName).sendKeys(randomName);
        driver.findElement(email).sendKeys(randomEmail);
        driver.findElement(password).sendKeys(randomPassword);
        driver.findElement(registerButton).click();
        Thread.sleep(500);
        driver.findElement(loginEmail).sendKeys(randomEmail);
        driver.findElement(loginPassword).sendKeys(randomPassword);
        driver.findElement(enter).click();
    }

    public void checkWrongPasswordRegistration() {
        driver.findElement(registration).click();
        driver.findElement(userName).sendKeys(randomName);
        driver.findElement(email).sendKeys(randomEmail);
        driver.findElement(password).sendKeys(RandomStringUtils.randomAlphanumeric(3));
        driver.findElement(registerButton).click();
        String text = driver.findElement(errorText).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected, text);
    }

    public void clickUpdatePassword() {
        driver.findElement(updatePassword).click();
    }

    public void sendEmailUpdatePassword() {
        driver.findElement(emailUpdate).sendKeys(randomEmail);
        driver.findElement(recover).click();
        String text = driver.findElement(By.xpath(".//h2[contains(text(),'Восстановление пароля')]")).getText(); //появилась страница восстановление пароля
        String expected = "Восстановление пароля";
        Assert.assertEquals(expected, text);
    }

    public void changeEmail() {
        driver.findElement(changeEmail).sendKeys(randomPassword);
        driver.findElement(code).sendKeys("blabla");
        driver.findElement(save).click();
    }

    public void clickLogOut() {
        driver.findElement(logOutButton).click();
    }

    public void checkSuccessfulLogOut() {
        String centralLoginBtn = driver.findElement(centralLoginButton).getText();
        String expectedText = "Вход";
        Assert.assertEquals(expectedText, centralLoginBtn);
    }
}
