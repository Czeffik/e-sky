package modules.uiDatePicker

import geb.Module

class UiDatePickerCalendarModule extends Module{
    static base = {$('.ui-datepicker-calendar')}
    static content = {
        calendarHeader { $('thead tr').moduleList(CalendarHeaderModule) }
        calendarWeeks {$('tbody tr').moduleList(CalendarWeekModule)}
    }
}
