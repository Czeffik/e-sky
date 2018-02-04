package modules.createAccount

import geb.Module

class FormHeadingModule extends Module {
    static base = { $('.form-heading') }
    static content = {
        heading { $('h2') }
        facebookButton { $('.btn-facebook') }
    }
}
