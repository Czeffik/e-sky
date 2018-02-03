import geb.spock.GebReportingSpec
import pages.MainPage
import pages.SearchResultPage

class SearchHotelsSpec extends GebReportingSpec {

    def 'Should search hotels in Kraków'() {
        given:
        String city = 'Kraków'
        to MainPage

        when:
        selectSearchCategory('hotels')
        fillHotelFields(city, 2018, 3, 5, 2018, 4, 15)
        hotelSearchFields.searchButton.click()
        loader.waitForLoaded()

        then:
        at SearchResultPage
        breadcrumbList.findAll{it.propertyName.text().contains(city)}.size()>0
    }
}
