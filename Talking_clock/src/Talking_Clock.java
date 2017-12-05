
import java.util.Date;
import java.util.Scanner;


public class Talking_Clock {

	private final static String[] representation_num = {"oh","one", "two", "three","four","five","six","seven","eight","nine","ten","eleven","twelve",
														"thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","Nineteen","twenty","thirty",
														"fourty","fifty"};
	static int talk_hr;
	static int talk_min;
	static String output_phrase; 
	
	public static int return_hr (String hr) {
		return  Integer.valueOf(hr.substring(0, 2));
	}
	
	public static int return_min (String min) {
		return Integer.valueOf(min.substring(min.length() - 2));
	}
	
	public static String check_time (int hour_word, int minutes_word) {
		
		String save_hr_word;
		String save_min_word;
		String final_word;
		String AmOrPm;
		
		if (hour_word > 12) {
			save_hr_word = representation_num[hour_word - 12];
			AmOrPm = "PM";
		}
		else {
			save_hr_word = representation_num[hour_word];
			AmOrPm = "AM";
		}
		
		if (minutes_word >= 20 && minutes_word <= 29) {
			save_min_word = representation_num[20] + representation_num[minutes_word % 10];
		}
		else if (minutes_word >= 30 && minutes_word <= 39) {
			save_min_word = representation_num[21] + representation_num[minutes_word % 10];
		}
		else if (minutes_word >= 40 && minutes_word <= 49) {
			save_min_word = representation_num[22] + representation_num[minutes_word % 10];
		}
		else if (minutes_word >= 50 && minutes_word <= 59) {
			save_min_word = representation_num[23] + representation_num[minutes_word % 10];
		}
		else {
			save_min_word = representation_num[minutes_word];
		}
		final_word = save_hr_word + " " + save_min_word + " " + AmOrPm;
		return final_word;
		 //representation_num[hour_word]+":"
	}
	
	public static void main(String args[]) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the the time in 24hr format (i.e 00:00).");
		String input = reader.nextLine();
		
		talk_hr = return_hr(input);
		talk_min = return_min(input);
		
		output_phrase = check_time(talk_hr,talk_min);
		System.out.println("It is " + output_phrase);
		
	}
	
	
}

