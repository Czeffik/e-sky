package testcases

import geb.spock.GebReportingSpec
import pages.MainPage
import pages.hotelsSearch.SearchResultPage
import utils.DateHelper

class SearchHotelsSpec extends GebReportingSpec {

    def 'Should search hotels in Kraków'() {
        given:
        DateHelper helper = new DataHelper()    
        def checkInDate = helper.getFutureDate(2)
        def checkOutDate = helper.getFutureDate(3)
        to MainPage

        when:
        selectSearchCategory('hotels')
        fillHotelFields('Kraków', checkInDate.year, checkInDate.month, 5, checkOutDate.year, checkOutDate.month, 15)
        hotelSearchFields.searchButton.click()
        loader.waitForSearchResults()

        then:
        at SearchResultPage
        breadcrumbList.findAll { it.propertyName.text().contains(city) }.size() > 0
    }
}
