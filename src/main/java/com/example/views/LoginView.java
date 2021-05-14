package com.example.views;

import com.example.views.common.ViewBase;
import org.openqa.selenium.By;

public class LoginView extends ViewBase {

    private final String EMAIL_INPUT_ID = "com.brubank.qappsbrubankinterview:id/username";
    private final String PASSWORD_INPUT_ID = "com.brubank.qappsbrubankinterview:id/password";
    private final String SIGN_IN_BUTTON_ID = "com.brubank.qappsbrubankinterview:id/loginButton";
    private final String ERROR_MESSAGE_TEXT_ID = "com.brubank.qappsbrubankinterview:id/snackbar_text";


    public void setEmail(String email) {
        setInput(By.id(EMAIL_INPUT_ID), email);
    }

    public void setPassword(String password) {
        setInput(By.id(PASSWORD_INPUT_ID), password);
    }

    public void clickSignIn() {
        click(By.id(SIGN_IN_BUTTON_ID));
    }

    public boolean isLoginDisplayed(){
        return isPresent(By.id(EMAIL_INPUT_ID));
    }

    public String getErrorMessage(){
        return getText(By.id(ERROR_MESSAGE_TEXT_ID));
    }
}
