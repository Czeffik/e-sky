package modules.headerWrapper

import geb.Module
import modules.userZone.UserZoneModule

class HeaderSideOptionsModule extends Module {
    static base = { $('.header-side-options') }
    static content = {
        userZoneMenuSection { $('.user-zone-menu-section') }
        signedIn { $('.signed-in .icon') }
        loggedUserMenu { $('.user-zone-menu-links li').moduleList(UserZoneModule) }
    }
}
