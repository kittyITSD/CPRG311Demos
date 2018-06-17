/**
 * Created on May 31, 2011
 *
 * Project: demo07-DateADTImplemetationExample 
 */
package dateADTExercise;

/**
 * Date.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: Date implementation for the DateADT specification as laid
 *	out in Exercise one.
 */
public class Date implements DateADT
{
	//Constants
	private final int BASE_YEAR = 2000;
	private final int BASE_MONTH = 1;
	
	//Attributes
	private int	days;
	
	/**
	 * Constructor to construct a date with a year y, month m, and day
	 * in the month d.
	 * 
	 * @param year the year as a 4 digit value
	 * @param month the month as 1 or 2 digit value
	 * @param day the day as 1 or 2 digit value
	 * @throws InvalidDateException is thrown if an invalid set of date
	 * components is passed.
	 */
	public Date(int year, int month, int day) throws InvalidDateException
	{
		createDate(day, month, year);	
	}
	
	
	/* (non-Javadoc)
	 * @see dateADTExercise.DateADT#getDays()
	 */
	public int getDays()
	{
		return days;
	}
	
	
	/* (non-Javadoc)
	 * @see dateADTExercise.DateADT#createDate(int, int, int)
	 */
	public void createDate(int day, int month, int year) throws InvalidDateException
	{
		if(month < 1 || month > 12 || day < 1 || day > numberOfDaysInMonth(month, year))
		{
			throw new InvalidDateException("Invalid Date");
		}
		int days = day - 1;
		
		// add the days for each of the months in the current year
		for(int i = 1; i < month; i++)
		{
			days += numberOfDaysInMonth(i, year);
		}
		
		// add the days in years through y - 1
		days += 365 * (year - 2000);
		
		// adjust the number of days for leap years
		if(year > 2000)
		{
			days += (year - 2001)/4 - (year - 2001)/100 + (year - 2001)/400 + 1;
		}
		else
		{
			days += (year - 2000)/4 - (year - 2000)/100 + (year - 2000)/400;
		}
		
		this.days = days;
	}
	
	/* (non-Javadoc)
	 * @see dateADTExercise.DateADT#dateFormatISO()
	 */
	public String dateFormatISO()
	{
		int y = BASE_YEAR;
		int m = BASE_MONTH;
		int d = this.days + 1;
		int last = 0;
		
		if(d > 0)
		{
			if(isLeap(y))
			{
				last = 366;
			}
			else
			{
				last = 365;
			}				
			while(d > last)
			{
				y++;
				d -= last;
				if(isLeap(y))
				{
					last = 366;
				}
				else
				{
					last = 365;
				}
			}
		}
		else
		{
			do
			{
				y--;
				if(isLeap(y))
				{
					last = 366;
				}
				else
				{
					last = 365;
				}
				d += last;
			}while(d <= 0);
		}
		
		while(d > (last = numberOfDaysInMonth(m, y)))
		{
			m++;
			d -= last;
		}
		if(d > 9)
		{		
			return (y + "-" + convertMonth(m) + "-" + d);
		}
		else
		{
			return (y + "-" + convertMonth(m) + "-" + "0"+d);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see dateADTExercise.DateADT#changeDate(int)
	 */
	public void changeDate(int days)
	{
		this.days += days;
	}
	
	
	/* (non-Javadoc)
	 * @see dateADTExercise.DateADT#compareTo(dateADTExercise.DateADT)
	 */
	public int compareTo(DateADT d)
	{
		Date date = (Date)d;
		if(this.days < date.days)
		{
			return -1;
		}
		else if(this.days > date.days)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	/* (non-Javadoc)
     * @see dateADTExercise.DateADT#daysBetween(dateADTExercise.DateADT)
     */
    public int daysBetween(DateADT d)
    {
    	Date date = (Date)d;
		return date.getDays() - this.days;
	}
	
	//***********************Internal auxillary methods*********************
	/**
	 * Method to calculate the number of days in a month and return that value
	 * to the calling method.
	 * @param m month in the year
	 * @param y current year value
	 * @return the number of days in a particular month m and year y or zero if
	 * not a valid month
	 */
	private int numberOfDaysInMonth(int m, int y)
	{
		switch(m)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if(isLeap(y))
				{
					return 29;
				}
				else
				{
					return 28;
				}
		}
		return 0;
	}
	
	/**
	 * Method to determine if a year is a leap year or not and return
	 * the result as a boolean true or false.
	 * @param y current year to be check if leap year
	 * @return boolean true if leap year and false if not leap year
	 */
	private boolean isLeap(int y)
	{
		if(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method to convert month as a number to month as 3 character string.
	 * @param month an integer representing the month to be converted.
	 * @return a String holding the 3 character month.
	 */
	private String convertMonth(int month)
	{
		switch(month)
		{
			case 1:
				return "Jan";
			case 2:
				return "Feb";
			case 3:
				return "Mar";
			case 4:
				return "Apr";
			case 5:
				return "May";
			case 6:
				return "Jun";
			case 7:
				return "Jul";
			case 8:
				return "Aug";
			case 9:
				return "Sep";
			case 10:
				return "Oct";
			case 11:
				return "Nov";
			case 12:
				return "Dec";
			default:
				return "Invalid month value";
		}
	}
}
