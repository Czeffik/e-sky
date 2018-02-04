package pages

import dataProviders.ImagePathsProvider
import geb.Page
import modules.LoaderModule
import modules.headerWrapper.HeaderWrapperModule
import modules.searchModules.HotelsSearchModule
import modules.searchModules.SearchCategoryModule
import modules.uiDatePicker.DatePickerModule

class MainPage extends Page {
    static url = ''
    static at = {
        driver.getTitle().contains('eSky')
        headerWrapper.logo.logoImg.getAttribute('src') == ImagePathsProvider.logoImage }
    static content = {
        headerWrapper { module HeaderWrapperModule }
        searchCategory { module SearchCategoryModule }
        hotelSearchFields { module HotelsSearchModule }
        calendarModule { module DatePickerModule }
        loader { module LoaderModule }
    }

    void selectSearchCategory(String category) {
        switch (category) {
            case 'flights': searchCategory.flights.click()
                break
            case 'hotels': searchCategory.hotels.click()
                break
            case 'insurance': searchCategory.insurance.click()
                break
            case 'cars': searchCategory.cars.click()
                break
            default: break
        }
    }

    void fillHotelFields(destination, checkInYear, checkInMonth, checkInDay, checkOutYear, checkOutMonth, checkOutDay) {
        hotelSearchFields.destinationField = destination
        hotelSearchFields.checkOutDateField.click()
        calendarModule.selectDate(checkOutYear, checkOutMonth, checkOutDay)
        hotelSearchFields.checkInDateField.click()
        calendarModule.selectDate(checkInYear, checkInMonth, checkInDay)
    }

    void toLoginView() {
        headerWrapper.headerSideOptions.userZoneMenuSection.click()
    }
}
