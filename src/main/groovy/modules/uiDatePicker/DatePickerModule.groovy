package modules.uiDatePicker

import geb.Module

class DatePickerModule extends Module {
    static base = { $('.ui-datepicker') }
    static content = {
        uiDatePickerHeader { module DatePickerHeaderModule }
        uiDatePickerCalendar { module UiDatePickerCalendarModule }
    }

    int getCurrentYear() {
        return uiDatePickerCalendar.calendarWeeks.first().availableDays.first().getAttribute("data-year") as int
    }

    int getCurrentMonth() {
        return uiDatePickerCalendar.calendarWeeks.first().availableDays.first().getAttribute("data-month") as int
    }

    void selectYear(int year) {
        int currentYear = getCurrentYear()
        if (currentYear > year) {
            println("Wrong year range!")
        } else {
            while (currentYear < year) {
                uiDatePickerHeader.nextButton.click()
                currentYear = getCurrentYear()
            }
        }
    }

    void selectMonth(int month) {
        //January is 0, december is 11
        if (month < 0 || month > 11) {
            println("Wrong month range!")
        } else {
            int currentMonth = getCurrentMonth()
            while (currentMonth < month) {
                uiDatePickerHeader.nextButton.click()
                currentMonth = getCurrentMonth()
            }
        }

    }

    def selectDay(int day) {
        int numberOfDisplayedWeeks = uiDatePickerCalendar.calendarWeeks.size()
        while (numberOfDisplayedWeeks > 1) {
            numberOfDisplayedWeeks = numberOfDisplayedWeeks - 1
            int numberOfAvailableDaysInWeek = uiDatePickerCalendar.calendarWeeks[numberOfDisplayedWeeks].availableDays.size()
            while (numberOfAvailableDaysInWeek > 1) {
                numberOfAvailableDaysInWeek = numberOfAvailableDaysInWeek - 1
                if (uiDatePickerCalendar.calendarWeeks[numberOfDisplayedWeeks].availableDays[numberOfAvailableDaysInWeek].dayNumber.text().toInteger() == day) {
                    uiDatePickerCalendar.calendarWeeks[numberOfDisplayedWeeks].availableDays[numberOfAvailableDaysInWeek].dayNumber.click()
                    return
                }
            }
        }
    }

    void selectDate(year, month, day) {
        selectYear(year)
        selectMonth(month)
        selectDay(day)
    }
}
