public class UseCase20 {

    public static void main(String[] args) {

        String[] bogieIds = {};
        String searchId = "BG101";

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(searchId + " found");
        } else {
            System.out.println(searchId + " not found");
        }

        System.out.println("UC20 execution completed...");
    }
}