package modules.searchModules

import geb.Module
import modules.uiDatePicker.DatePickerModule

class HotelsSearchModule extends Module{
    static base = {$'.hotels-qsf'}
    static content ={
        destinationField {$'#destination'}
        checkInDateField {$'#checkInDate'}
        checkOutDateField {$'#checkOutDate'}
        guestsField {$'#guests'}
        searchButton {$'.qsf-search'}
    }
}
