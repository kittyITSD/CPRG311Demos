/**
 * 
 */
package dateADTExercise;

/**
 * @author kitty
 *
 * Class Definition: Test program for the DateADT implementation (specifically - the Date Class)
 * 
 */
public class RunDate {

	/**
	 * I'd like to say something smart about this class, but nothing comes to mind...
	 */
	public RunDate() {
		// TODO Auto-generated constructor stub
		// yes i use the magic of eclipse :P
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			// hardcoded dates, bad kitty!
			Date testDate = new Date(2012, 9, 29);
			Date testDate2 = new Date(2012, 10, 18);
			
			System.out.println("Date in ISO: " + testDate.dateFormatISO());
			
			testDate.changeDate(10);
			System.out.println("Changed Date (+10) in ISO: " + testDate.dateFormatISO());
			
			testDate.changeDate(-10);
			System.out.println("Changed Date (-10) in ISO: " + testDate.dateFormatISO());
			
			System.out.println("Days Between the two dates is: " + testDate.daysBetween(testDate2));
			
			int compared = testDate.compareTo(testDate2);
			if (compared == 0) {
				System.out.println("The two dates are the same!");
			}
			else if (compared < 0 ) {
				System.out.println("The new date is newer than current date!");
			}
			else {
				System.out.println("The new date is older than current date!");
			}
			
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			// oh no! what should I do???
			e.printStackTrace();
		}		
	}

}
