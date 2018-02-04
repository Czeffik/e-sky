package pages

class LoggedPage extends MainPage {
    static at = {
        headerWrapper.headerSideOptions.signedIn.displayed
    }

    void openUserMenu() {
        headerWrapper.headerSideOptions.click()
    }
}
