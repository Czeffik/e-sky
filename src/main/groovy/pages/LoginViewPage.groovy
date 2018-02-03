package pages

import geb.Page
import modules.userZone.LoginModule

class LoginViewPage extends Page {
    static at = {
        userZoneModule.facebookButton.displayed
        userZoneModule.form.confirmButton.displayed
        userZoneModule.form.emailField.displayed
        userZoneModule.form.passwordField.displayed
    }

    static content = {
        userZoneModule { module LoginModule }
    }

    void loginViaFacebookButton(){
        userZoneModule.facebookButton.click()
    }

    void fillForm(email, password){
        userZoneModule.form.emailField = email
        userZoneModule.form.passwordField = password
    }

    void fillFormAndLogIn(email, password){
        fillForm(email, password)
        userZoneModule.form.confirmButton.click()
    }
}
