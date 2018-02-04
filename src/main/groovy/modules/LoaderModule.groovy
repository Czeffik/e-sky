package modules

import geb.Module

class LoaderModule extends Module {
    static content = {
        searchLoader { $('.search-results-rendering') }
        cssLoader { $('.css-loader min').findAll() }
        customDialogMask { $('.custom-dialog-mask').findAll() }
        buttonDisabled { $('.btn-disabled').findAll() }
    }

    def waitForSearchResults(double time = 20) {
        waitFor(time) {
            !searchLoader.isDisplayed()
        }
    }

    def waitForLoggedOn(double time = 20) {
        waitFor(time) {
            buttonDisabled.size() == 0
        }
    }

    def waitForDisableCustomDialogMask(double time = 20) {
        waitFor(time) {
            customDialogMask.size() == 0
        }
    }
}
