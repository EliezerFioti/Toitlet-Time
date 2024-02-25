import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Random;

public class ToiletTimeTester {

	public static void main(String[] args) {
		
		ToiletTime toilet = new ToiletTime();
        Random rand = new Random();
        
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = LocalDate.of(endDate.getYear(), 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
        LocalDate date = startDate;
        int poopsPerWeek = 0;

        System.out.println("Bowel Movement on:\n");

        while (!date.isAfter(endDate)) {
            int randomNumOfPoopsPerDay = rand.nextInt(3) + 1;
            for (int j = 0; j < randomNumOfPoopsPerDay; j++) {
                toilet.didYouPoop(true, date);
                poopsPerWeek++;
                toilet.incrementNumOfPoopsPerYear();
            }

            int weekOfYear = date.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());

            // Check if it's the last day of the week (Saturday) or the last day of the year
            if (date.getDayOfWeek().equals(java.time.DayOfWeek.SATURDAY) || date.equals(endDate)) {
                if (date.getDayOfWeek().equals(java.time.DayOfWeek.SUNDAY)) {
                    // If the week starts on Sunday, adjust weekOfYear
                    weekOfYear--;
                }
                System.out.println(date.format(formatter) + ":  " + randomNumOfPoopsPerDay + "\n");
                System.out.println("Bowel Movement in week " + weekOfYear + ": " + poopsPerWeek + "\n");
                poopsPerWeek = 0; // Reset poopsPerWeek counter       
            } 
            else {
                System.out.println(date.format(formatter) + ":  " + randomNumOfPoopsPerDay);
            }

            date = date.plusDays(1);
        }
        
        for (Month month: Month.values()) {
        	//LocalDate firstDayOfMonth = LocalDate.of(endDate.getYear(), month, 1);
        	int poopsPerMonth = toilet.getNumOfPoopsPerMonth(month);
        	System.out.println("Bowel Movements in " + month + ": " + poopsPerMonth);
        }
        
        System.out.println("\nTotal Bowel Movement this years: " + toilet.getNumOfPoopsPerYear());
	}

}