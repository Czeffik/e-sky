package modules.headerWrapper

import geb.Module

class HeaderWrapperModule extends Module {
    static base = { $('.header-wrapper') }
    static content = {
        logo { module LogoModule }
        hamburger { module HamburgerModule }
        mainNavigation { module MainNavigationModule }
        headerSideOptions { module HeaderSideOptionsModule }
    }
}
