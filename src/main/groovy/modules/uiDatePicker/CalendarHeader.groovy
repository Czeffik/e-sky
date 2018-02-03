package modules.uiDatePicker

import geb.Module

class CalendarHeader extends Module{
    static content = {
        day {$('th')}
    }
}
