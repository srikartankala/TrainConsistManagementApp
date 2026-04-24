import java.util.Arrays;

public class UseCase19 {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                found = true;
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("\nSearch Result:");
        if (found) {
            System.out.println(key + " found");
        } else {
            System.out.println(key + " not found");
        }
    }
}