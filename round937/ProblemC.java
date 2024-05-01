package round937;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) {
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        String timeFormat24String = scanner.next();
        System.out.println(solve(timeFormat24String));
    }
    private static String solve(final String timeFormat24String) {
        int splitAt = timeFormat24String.indexOf(':', 0);
        Integer hour = Integer.parseInt(timeFormat24String.substring(0, splitAt));
        String minuteString = timeFormat24String.substring(splitAt + 1, timeFormat24String.length());
        if(hour > 11) {
            if(hour == 12){
                return timeFormat24String + " PM";
            }else{
                hour = hour - 12;
                String hourString = null;
                if(hour < 10) hourString = "0" + hour;
                else hourString = hour.toString();
                return hourString + ":" + minuteString + " PM";
            }
        }else{
            if(hour == 0){
                return "12:" + minuteString + " AM";
            } else return timeFormat24String + " AM";
        }
    }
}
