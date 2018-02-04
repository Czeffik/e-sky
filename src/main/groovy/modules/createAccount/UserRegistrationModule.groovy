package modules.createAccount

import geb.Module

class UserRegistrationModule extends Module {
    static base = { $('.user-registration') }
    static content = {
        emailField { $('#user_email') }
        passwordFirstFeild { $('#user_password_first') }
        passwordSecondField { $('#user_password_second') }
        userTermsCheckbox { $('#user_termsAccepted') }
        createAccountButton { $('#user_register') }
        logInButton { $('.change-small') }
        errorMessage { $('.error-msg') }
    }
}
