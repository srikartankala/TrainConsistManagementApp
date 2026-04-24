import java.util.regex.*;

public class UseCase11 {

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        System.out.println("Train ID: " + trainId + " -> " + (isTrainValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code: " + cargoCode + " -> " + (isCargoValid ? "Valid" : "Invalid"));
    }
}