import java.util.Arrays;

public class UseCase17 {

    public static void main(String[] args) {

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
    }
}