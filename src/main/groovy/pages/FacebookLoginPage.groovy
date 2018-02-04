package pages

import geb.Page

class FacebookLoginPage extends Page {
    static at = {
        homelink.text() == 'Facebook'
        driver.getCurrentUrl().startsWith('https://www.facebook.com')
    }
    static content = {
        homelink { $('#homelink') }
        emailField { $('#email') }
        passwordField { $('#pass') }
        checkbox { $('#offline_access') }
        confirmButton { $('#loginbutton') }
    }

    void fillFormAndLogIn(email, password) {
        emailField = email
        passwordField = password
        confirmButton.click()
    }
}
