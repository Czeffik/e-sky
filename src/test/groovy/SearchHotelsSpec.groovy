import geb.spock.GebReportingSpec
import pages.MainPage
import pages.hotelsSearch.SearchResultPage
import utils.DateHelper

class SearchHotelsSpec extends GebReportingSpec {

    def 'Should search hotels in Kraków'() {
        given:
        def checkInDate = new DateHelper().getFutureDate(2)
        def checkOutDate = new DateHelper().getFutureDate(3)
        println(checkInDate)
        println(checkOutDate)
        String city = 'Kraków'
        to MainPage

        when:
        selectSearchCategory('hotels')
        fillHotelFields(city, checkInDate.year, checkInDate.month, 5, checkOutDate.year, checkOutDate.month, 15)
        hotelSearchFields.searchButton.click()
        loader.waitForSearchResults()

        then:
        at SearchResultPage
        breadcrumbList.findAll { it.propertyName.text().contains(city) }.size() > 0
    }
}
