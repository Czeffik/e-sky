package modules.uiDatePicker

import geb.Module

class DatePickerHeaderModule extends Module{
    static base = {$('.ui-datepicker-header')}
    static content = {
        previousButton {$'.ui-datepicker-prev'}
        nextButton {$'.ui-datepicker-next'}
        month {$'.ui-datepicker-month'}
        year {$'.ui-datepicker-year'}
    }
}
