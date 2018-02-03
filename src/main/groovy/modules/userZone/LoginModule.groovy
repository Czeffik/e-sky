package modules.userZone

import geb.Module

class LoginModule extends Module {
    static base = { $('.user-zone-login-dialog') }
    static content = {
        closeButton { $('.custom-dialog-close') }
        facebookButton { $('.login-facebook') }
        form { module LoginFormModule }
        remindPassword {$('.remind-password')}
        signUpButton {$('.sign-up-info .btn')}
    }
}
