public class UseCase18 {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        System.out.println("\nSearch Result:");
        if (found) {
            System.out.println(searchId + " found");
        } else {
            System.out.println(searchId + " not found");
        }
    }
}