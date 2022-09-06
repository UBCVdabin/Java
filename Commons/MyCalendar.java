package Commons;

public class MyCalendar {
    public static String MonthofIntToString(int month) {
        String result;
        
        switch (month) {
            case 1: 
                result = "January";
                break;
            case 2: 
                result = "Febuaray";
                break;
            case 3: 
                result = "March";
                break;
            case 4: 
                result = "April";
                break;
            case 5: 
                result = "May";
                break;
            case 6: 
                result = "June";
                break;
            case 7: 
                result = "July";
                break;
            case 8: 
                result = "August";
                break;
            case 9: 
                result = "September";
                break;
            case 10: 
                result = "October";
                break;        
            case 11: 
                result = "November";
                break;
            default:
                result = "December";
                break;
        }
        return result;
    }

    public static String DayofIntToString_Zeller(int day) {
        String result;
        
        switch (day) {
            case 1: 
                result = "Sunday";
                break;
            case 2: 
                result = "Monday";
                break;
            case 3: 
                result = "Tuesday";
                break;
            case 4: 
                result = "Wednesday";
                break;
            case 5: 
                result = "Thursday";
                break;
            case 6: 
                result = "Friday";
                break;
            default:
                result = "Saturday";
                break;
        }
        return result;
    }

    public static int GetDayOfTheWeek(int year, int month, int day) {
        if (month <= 2) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;
        int h = day + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j;

        return h % 7;
    }

    public static String DayofIntToString(int day) {
        String result;
        
        switch (day) {
            case 1: 
                result = "Monday";
                break;
            case 2: 
                result = "Tuesday";
                break;
            case 3: 
                result = "Wednesday";
                break;
            case 4: 
                result = "Thursday";
                break;
            case 5: 
                result = "Friday";
                break;
            case 6: 
                result = "Saturday";
                break;
            default:
                result = "Sunday";
                break;
        }
        return result;
    }

    public static boolean CheckLeapYear (int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int GetDayofMonth(int month, int year) {
        boolean leapYear = CheckLeapYear(year);

        if ((month < 8 && month % 2 != 0) || (month >= 8 && month % 2 == 0)) {
            return 31;
        }
        else {
            if (month == 2) {
                if (leapYear)
                    return 29;
                else
                    return 28;
            }
            return 30;
        }
    }
}
