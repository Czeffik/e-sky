package modules.uiDatePicker

import geb.Module

class CalendarHeaderModule extends Module {
    static content = {
        day { $('th') }
    }
}
