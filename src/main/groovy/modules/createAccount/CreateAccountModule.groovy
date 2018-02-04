package modules.createAccount

import geb.Module

class CreateAccountModule extends Module {
    static base = { $('.form-wrap') }
    static content = {
        formHeading { module FormHeadingModule }
        userRegistration { module UserRegistrationModule }
    }

    void fillFields(email, passwordFirst, passwordSecond, boolean acceptTerms) {
        userRegistration.emailField = email
        userRegistration.passwordFirstFeild = passwordFirst
        userRegistration.passwordSecondField = passwordSecond
        if (acceptTerms) {
            userRegistration.userTermsCheckbox.click()
        }
    }

    void fillFields(email, password, boolean acceptTerms) {
        fillFields(email, password, password, acceptTerms)
    }

    void fillFieldsAncClickButton(email, password, boolean acceptTerms) {
        fillFields(email, password, acceptTerms)
        userRegistration.createAccountButton.click()
    }

    void fillFieldsAncClickButton(email, passwordFirst, passwordSecond, boolean acceptTerms) {
        fillFields(email, passwordFirst, passwordSecond, acceptTerms)
        userRegistration.createAccountButton.click()
    }
}
