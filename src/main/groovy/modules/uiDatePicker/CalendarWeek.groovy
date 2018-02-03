package modules.uiDatePicker

import geb.Module

class CalendarWeek extends Module{
    static content = {
        availableDays {$('[data-handler=selectDay]').moduleList CalendarDay}
//        notAvailableDays {$('.ui-datepicker-unselectable').moduleList CalendarDay}
    }
}
