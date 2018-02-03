package modules.uiDatePicker

import geb.Module

class CalendarDay extends Module{
    static content = {
        dayNumber {$('.ui-state-default')}
    }
}
