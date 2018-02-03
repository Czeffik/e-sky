package modules.uiDatePicker

import geb.Module

class UiDatePickerCalendar extends Module{
    static base = {$('.ui-datepicker-calendar')}
    static content = {
        calendarHeader { $('thead tr').moduleList(CalendarHeader) }
        calendarWeeks {$('tbody tr').moduleList(CalendarWeek)}
    }
}
