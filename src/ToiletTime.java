import java.time.Month;
import java.util.HashMap;
import java.time.DayOfWeek; // DayofWeekClass
import java.time.LocalDate; // LocalDate class

public class ToiletTime {
	
	private HashMap<DayOfWeek, Integer> numOfPoopsPerDay = new HashMap<>();
	private HashMap<Month, Integer> numOfPoopsPerMonth = new HashMap<>();
	private int numOfPoopsPerWeek = 0;
	private int numOfPoopsPerYear = 0;
	private boolean didYouPoop = false;
	private LocalDate lastPoopDate;
	
	/**
	 * Retrieves the number of bowel movement for the specified day.
	 * 
	 * @param dayOfWeek the day of the week to retrieve the bowel movement count for.
	 * @return the number of bowel movements for the specified day of the week.
	 */
	public int getNumOfPoopsPerDay(DayOfWeek dayOfWeek) {
		return numOfPoopsPerDay.getOrDefault(dayOfWeek, 0);
	}
	
	/**
	 * Increments the count of bowel movements for the last recorded date,
	 * if a bowel movement was logged and the date is not null.
	 */
	public void incrementNumOfPoopsPerDay() {
		if (didYouPoop && lastPoopDate != null) {
			int count = numOfPoopsPerDay.getOrDefault(lastPoopDate.getDayOfWeek(), 0);
            numOfPoopsPerDay.put(lastPoopDate.getDayOfWeek(), count + 1);
		}
	}
	
	/**
	 * Retrieves the total number of bowel movements for the current week.
	 *
	 * @return the total number of bowel movements for the current week.
	 */
	public int getNumOfPoopsPerWeek() {
        return numOfPoopsPerWeek;
    }
	
	/**
	 * Resets the count of bowel movements for the current week to zero.
	 */
    public void resetNumOfPoopsPerWeek() {
        numOfPoopsPerWeek = 0;
    }
    
    /**
     * Increments the count of bowel movements for the current week by one.
     */
    public void incrementNumOfPoopsPerWeek() {
        numOfPoopsPerWeek++;
    }
    
    /**
     * Retrieves the number of bowel movements for the specified month.
     *
     * @param month the month to retrieve bowel movement count for.
     * @return the number of bowel movements for the specified month.
     */
	public int getNumOfPoopsPerMonth(Month month) { 
	    return numOfPoopsPerMonth.getOrDefault(month, 0);
	}
	
	/**
	 * Increments the count of bowel movements for the month of the last recorded date,
	 * if the date is not null and is not in the future.
	 */
	public void setNumOfPoopsPerMonth() {
	    if (lastPoopDate != null && !isDateInTheFuture(lastPoopDate)) {
	        Month month = lastPoopDate.getMonth();
	        int count = numOfPoopsPerMonth.getOrDefault(month, 0);
	        numOfPoopsPerMonth.put(month, count + 1);
	    }
	}
	
	/**
	 * Retrieves the total number of bowel movements for the current year.
	 *
	 * @return the total number of bowel movements for the current year.
	 */
	public int getNumOfPoopsPerYear() {
        return numOfPoopsPerYear;
    }
	
	/**
	 * Increments the count of bowel movements for the current year by one.
	 */
    public void incrementNumOfPoopsPerYear() {
    	numOfPoopsPerYear++;
    }
    
    /**
     * Retrieves the status of whether a bowel movement was recorded.
     *
     * @return true if a bowel movement was recorded, false otherwise.
     */
	public boolean isDidYouPoop() {
		return didYouPoop;
	}
	
	/**
	 * Records a bowel movement with the specified date.
	 *
	 * @param didYouPoop   true if a bowel movement occurred, false otherwise.
	 * @param lastPoopDate the date of the recorded bowel movement.
	 */
	public void didYouPoop(boolean didYouPoop, LocalDate lastPoopDate) {
		this.didYouPoop = didYouPoop;
		if(didYouPoop) {
			this.lastPoopDate = lastPoopDate;
			incrementNumOfPoopsPerDay();
			setNumOfPoopsPerMonth();
			this.didYouPoop = false;
		}
	}

	/**
	 * Checks if the specified date is in the future.
	 *
	 * @param dateToCheck the date to check.
	 * @return true if the specified date is in the future, false otherwise.
	 */
	public static boolean isDateInTheFuture(LocalDate dateToCheck) {
		LocalDate currentDate = LocalDate.now();	
		return dateToCheck.isAfter(currentDate); 
	}

}