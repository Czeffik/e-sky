package modules.headerWrapper

import geb.Module

class LogoModule extends Module {
    static base = { $('.logo') }
    static content = {
        logoImg(wait: true) { $('.logo-img') }
        backToMainPage { $('.back-to-mainpage') }
    }
}
