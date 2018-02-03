package modules.userZone

import geb.Module

class LoginFormModule extends Module {
    static content = {
        emailField { $('.fieldname-username') }
        passwordField { $('.fieldname-password') }
        confirmButton { $('.login-normal') }
        rememberMeCheckBox { $('.checkbox') }
        errorMessage { $('.error-msg') }
    }
}
