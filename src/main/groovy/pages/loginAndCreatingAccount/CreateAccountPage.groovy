package pages.loginAndCreatingAccount

import geb.Page
import modules.LoaderModule
import modules.createAccount.CreateAccountModule

class CreateAccountPage extends Page {
    static url = '/registration'
    static at = {
        createAccountModule.formHeading.heading.displayed
        createAccountModule.formHeading.facebookButton.displayed
        createAccountModule.userRegistration.emailField.displayed
        createAccountModule.userRegistration.passwordFirstFeild.displayed
        createAccountModule.userRegistration.passwordSecondField.displayed
        createAccountModule.userRegistration.createAccountButton.displayed
    }
    static content = {
        createAccountModule { module CreateAccountModule }
        loader { module LoaderModule }
    }
}
