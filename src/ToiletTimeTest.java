import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class ToiletTimeTest {
	
	@Test 
	public void singlePoopPerDayTest() {
		var toilet = new ToiletTime();
		LocalDate poopDate = LocalDate.now();
		
		toilet.didYouPoop(true, poopDate);
		
		assertEquals(1, toilet.getNumOfPoopsPerDay(poopDate.getDayOfWeek()), "The expected number of times pooped today: 1");	
	}

	@Test
	public void multiplePoopsPerDayTest() {
		var toilet = new ToiletTime();
		LocalDate poopDate = LocalDate.now();
		
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		toilet.didYouPoop(true, poopDate);
		
		assertEquals(6, toilet.getNumOfPoopsPerDay(poopDate.getDayOfWeek()), "The expected number of times pooped today: 6");
	}
	
	@Test
	public void multiplePoopsPerWeekTest() {
		var toilet = new ToiletTime();
		
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
		toilet.didYouPoop(false, LocalDate.of(2022, 1, 27));
		toilet.didYouPoop(false, LocalDate.of(2022, 2, 28));
		toilet.didYouPoop(false, LocalDate.of(2023, 3, 29));
		toilet.didYouPoop(false, LocalDate.of(2023, 4, 30));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 27));
		toilet.didYouPoop(false, LocalDate.of(2024, 1, 27));
		toilet.didYouPoop(false, LocalDate.of(2026, 1, 27));
		toilet.didYouPoop(false, LocalDate.of(2026, 1, 27));
		toilet.didYouPoop(false, LocalDate.of(2026, 1, 28));
		toilet.didYouPoop(false, LocalDate.of(2026, 1, 29));

		assertEquals(7, toilet.getNumOfPoopsPerWeek(), "The expected number of times pooped today: 7");
	}
	
	@Test
	public void multiplePoopsPerMonthTest() {
	    var toilet = new ToiletTime();
	    
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 1));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 2));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 3));
	    toilet.didYouPoop(true, LocalDate.of(2024, 1, 4));
	    
	    assertEquals(7, toilet.getNumOfPoopsPerMonth(Month.JANUARY), "The expected number of times pooped this Month: 7");
	}
	
	@Test
	public void multiplePoopsPerYearTest() {
	    var toilet = new ToiletTime();
	    
	    // Simulate multiple poops per year
	    toilet.didYouPoop(false, LocalDate.of(2023, 4, 15));
	    toilet.didYouPoop(false, LocalDate.of(2023, 5, 25));
	    toilet.didYouPoop(false, LocalDate.of(2023, 5, 30));
	    toilet.didYouPoop(false, LocalDate.of(2023, 6, 8));
	    toilet.didYouPoop(false, LocalDate.of(2023, 7, 18));
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
	    toilet.didYouPoop(false, LocalDate.of(2025, 8, 30));
	    toilet.didYouPoop(false, LocalDate.of(2025, 9, 12));
	    toilet.didYouPoop(false, LocalDate.of(2025, 10, 6));
	    toilet.didYouPoop(false, LocalDate.of(2025, 11, 22));
	    toilet.didYouPoop(false, LocalDate.of(2025, 12, 14));
	     
	    assertEquals(18, toilet.getNumOfPoopsPerYear(), "The expected number of times pooped this year: 18");
	}

}