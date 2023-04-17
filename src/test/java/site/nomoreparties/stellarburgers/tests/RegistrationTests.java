package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.BrowserSetUp;
import pom.MainPage;
import pom.UserRegistrationPage;

public class RegistrationTests {
    @Rule
    public BrowserSetUp browserRule = new BrowserSetUp();

    @Test
    @DisplayName("Регистрация с некоректным паролем")
    public void registrationFailsWithWrongPassword() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserRule.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkWrongPasswordRegistration();
    }

    @Test
    @DisplayName("Регистрация с корректными данными")
    public void successfulRegistrationWithCorrectData() throws InterruptedException { //провера успешной регистрации через Войти
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }

    @Test
    @DisplayName("Регистрация через личный кабинет")
    public void successfulLoginViaPersonalAccount() throws InterruptedException {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickPersonalAccount();
        userRegistrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }

    @Test
    @DisplayName("Восстановить пароль")
    public void passwordUpdatedSuccessfully() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserRule.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickPersonalAccount();
        userRegistrationPage.clickUpdatePassword();
        userRegistrationPage.sendEmailUpdatePassword();
        userRegistrationPage.changeEmail();
    }

    @Test
    @DisplayName("Разлогинивание пользователя")
    public void successfulLogOut() {
        UserRegistrationPage userRegistrationPage = new UserRegistrationPage(browserRule.getDriver());
        userRegistrationPage.open();
        userRegistrationPage.clickLogin();
        userRegistrationPage.checkSuccessfulLogOut();
    }
}