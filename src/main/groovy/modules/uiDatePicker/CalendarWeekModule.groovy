package modules.uiDatePicker

import geb.Module

class CalendarWeekModule extends Module {
    static content = {
        availableDays { $('[data-handler=selectDay]').moduleList CalendarDayModule }
    }
}
