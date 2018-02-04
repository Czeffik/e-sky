package modules.uiDatePicker

import geb.Module

class CalendarDayModule extends Module{
    static content = {
        dayNumber {$('.ui-state-default')}
    }
}
