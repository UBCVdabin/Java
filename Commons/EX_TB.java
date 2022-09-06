package Commons;

public class EX_TB {
    public static void ShowCurrentTime(int GMT) {
        
        // Obtain the total milliseconds since midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();
        
        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;
        
        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;
        
        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;
        
        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;
        
        // Obtain the total hours
        long totalHours = totalMinutes / 60;
        
        // Compute the current hour
        long currentHour = totalHours % 24 + GMT;
        
        currentHour %= 12;
        // Display results
        System.out.println("Current time is " + currentHour + ":" 
        + currentMinute + ":" + currentSecond + (currentHour / 12 == 1 ? " PM" : " AM"));
    }

    public static void PrintChange(double amount) {    
      double remainingAmount = amount;
 
      // Find the number of one dollars 
      int numberOfOneDollars = (int)(remainingAmount / 100);
      remainingAmount = remainingAmount % 100;
      // Display results 
      System.out.println("Your amount " + amount + " consists of"); 
      System.out.println(" " + numberOfOneDollars + " dollars");
      System.out.println(" " + (int)remainingAmount + " cents");
    }

    public static void ComputeChange(double amount) {
            
        int remainingAmount = (int)(amount * 100);
           
        // Find the number of one dollars 
        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;
                
        // Find the number of quarters in the remaining amount 
        int numberOfQuarters = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;
          
        // Find the number of dimes in the remaining amount 
        int numberOfDimes = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;
          
        // Find the number of nickels in the remaining amount 
        int numberOfNickels = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;
          
        // Find the number of pennies in the remaining amount 
        int numberOfPennies = remainingAmount;
           
        // Display results 
        System.out.println("Your amount " + amount + " consists of"); 
        
        if(numberOfOneDollars > 0)
                System.out.println(" " + numberOfOneDollars + " dollars");
        if(numberOfQuarters > 0)
                System.out.println(" " + numberOfQuarters + " quarters ");
        if(numberOfDimes > 0)        
                System.out.println(" " + numberOfDimes + " dimes"); 
        if(numberOfNickels > 0)         
                System.out.println(" " + numberOfNickels + " nickels");
        if(numberOfPennies > 0)        
                System.out.println(" " + numberOfPennies + " pennies"); 
    }     
}

