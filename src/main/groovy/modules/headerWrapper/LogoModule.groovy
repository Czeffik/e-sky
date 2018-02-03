package modules.headerWrapper

import geb.Module

class LogoModule extends Module {
    static base = { $('.logo') }
    static content = {
        logoImg { $('.logo-img') }
        backToMainPage { $('.back-to-mainpage') }
    }
}
