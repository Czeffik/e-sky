package utils

class DateHelper {
    private int currentYear 
    private int currentMonth 
    private int currentDay 
    DateHelper(){
     currentYear = Calendar.getInstance().get(Calendar.YEAR)
     currentMonth = Calendar.getInstance().get(Calendar.MONTH)
     currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    }
    

    int getCurrentYear() {
        return currentYear
    }

    int getCurrentMonth() {
        return currentMonth
    }

    int getCurrentDay() {
        return currentDay
    }

    int getNextMonth() {
        if (currentMonth < 11) {
            return currentMonth + 1
        } else {
            return 0
        }
    }

    def getNextDate() {
        if (currentMonth < 11) {
            return [year: currentYear, month: currentMonth + 1]
        } else {
            return [year: currentYear + 1, month: 0]
        }
    }

    def getFutureDate(int months){
        int sum = currentMonth + months
        if (sum > 11){
            return [year: currentYear + 1, month: sum - 11]
        }
        else{
            return [year: currentYear, month: sum]
        }
    }
}
