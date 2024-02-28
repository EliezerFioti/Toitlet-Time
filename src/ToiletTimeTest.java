import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class ToiletTimeTest {
	
	@Test 
	public void getNumOfPoopsPerDay_SinglePoopPerDayTest() {
		var toilet = new ToiletTime();
		LocalDate poopDate = LocalDate.now();
		
		toilet.didYouPoop(true, poopDate);
		
		assertEquals(1, toilet.getNumOfPoopsPerDay(poopDate.getDayOfWeek()), "The expected number of times pooped today: 1");	
	}

	@Test
	public void getNumOfPoopsPerDay_MultiplePoopsPerDayTest() {
		var toilet = new ToiletTime();
		LocalDate poopDate = LocalDate.now();
		
		// Log multiple poops for different dates within the same day
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		
		assertEquals(6, toilet.getNumOfPoopsPerDay(poopDate.getDayOfWeek()), "The expected number of times pooped today: 6");
	}
	
	@Test
	public void getNumOfPoopsPerDay_NoPoopsPerdayTest() {
		var toilet = new ToiletTime();
		LocalDate poopDate = LocalDate.now();
		
		toilet.didYouPoop(false, poopDate);
		toilet.didYouPoop(false, poopDate);
		toilet.didYouPoop(false, poopDate);
		toilet.didYouPoop(false, poopDate);
		toilet.didYouPoop(false, poopDate);
		toilet.didYouPoop(false, poopDate);
		
		assertEquals(0, toilet.getNumOfPoopsPerDay(poopDate.getDayOfWeek()), "The expected number of times pooped today: 0");
	}
	
	@Test
	public void getNumOfPoopsPerWeek_MultiplePoopsPerWeekTest() {
		var toilet = new ToiletTime();
		
		// Log multiple poops for different dates within the same week
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 28));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 28));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 29));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 29));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 29));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 30));
		toilet.incrementNumOfPoopsPerWeek();
		toilet.didYouPoop(true, LocalDate.of(2024, 1, 31));
		toilet.incrementNumOfPoopsPerWeek();

		assertEquals(7, toilet.getNumOfPoopsPerWeek(), "The expected number of times pooped today: 7");
	}
	
	@Test
	public void getNumOfPoopsPerWeek_NoPoopsPerWeekTest() {
		var toilet = new ToiletTime();
		
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 7));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 7));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 8));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 9));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 11));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 12));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 13));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 13));

		assertEquals(0, toilet.getNumOfPoopsPerWeek(), "The expected number of times pooped today: 0");
	}
	
	@Test
	public void getNumOfPoopsPerMonth_MultiplePoopsPerMonthTest() {
	    var toilet = new ToiletTime();
	    
	    // Log multiple poops for different dates within the same month
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 1));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 4));    
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 5));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 6));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 6));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 7));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 8));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 8));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 9));	    
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 9));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 11));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 12));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 12));
	    
	    assertEquals(21, toilet.getNumOfPoopsPerMonth(Month.JANUARY), "The expected number of times pooped this Month: 21");
	}
	
	@Test
	public void getNumOfPoopsPerMonth_NoPoopsPerMonthTest() {
	    var toilet = new ToiletTime();
	    
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 1));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 4));    
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 5));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 6));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 6));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 7));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 8));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 8));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 9));	    
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 9));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 10));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 11));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 12));
	    toilet.didYouPoop(false, LocalDate.of(2024, 1, 12));
	    
	    assertEquals(0, toilet.getNumOfPoopsPerMonth(Month.JANUARY), "The expected number of times pooped this Month: 0");
	}
	
	@Test
	public void getNumOfPoopsPerMonth_MultiplePoopsPerYearTest() {
	    var toilet = new ToiletTime();
	    
	    // Log multiple poops for different dates within the same year
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 1));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 15));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 2, 5));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 2, 6));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 2, 9));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 3, 20));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 3, 21));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 4, 10));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 4, 15));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 5, 25));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 5, 30));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 6, 8));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 7, 18));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 8, 30));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 9, 12));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 10, 6));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 11, 22));
	    toilet.incrementNumOfPoopsPerYear();
	    toilet.didYouPoop(true, LocalDate.of(2024, 12, 14));
	    toilet.incrementNumOfPoopsPerYear();
	     
	    assertEquals(18, toilet.getNumOfPoopsPerYear(), "The expected number of times pooped this year: 18");
	}
	
	@Test 
    public void isDateInTheFuture_OneDayInFuture() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertTrue(ToiletTime.isDateInTheFuture(futureDate));
    }
	
	@Test 
    public void isDateInTheFuture_FutureDate() {
        LocalDate futureDate = LocalDate.now().plusYears(1);
        assertTrue(ToiletTime.isDateInTheFuture(futureDate));
    }
	
	@Test 
    public void isDateInTheFuture_SameAsCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        assertFalse(ToiletTime.isDateInTheFuture(currentDate));
    }
	
	@Test 
    public void isDateInTheFuture_OneDayInPast() {
        LocalDate futureDate = LocalDate.now().minusDays(1);
        assertFalse(ToiletTime.isDateInTheFuture(futureDate));
    }

	@Test 
    public void isDateInTheFuture_VeryDistantPastDate() {
        LocalDate distantPastDate = LocalDate.of(1000, 1, 1);
        assertFalse(ToiletTime.isDateInTheFuture(distantPastDate));
    }

}