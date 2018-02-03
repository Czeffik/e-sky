package modules

import geb.Module

class Loader extends Module{
    static content = {
        searchLoader {$('.search-results-rendering')}
    }

    def waitForLoaded(double time = 20) {
        waitFor(time) {
            !searchLoader.isDisplayed()
        }
    }
}
