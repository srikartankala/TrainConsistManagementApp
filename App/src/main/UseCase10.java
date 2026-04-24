import java.util.*;
import java.util.stream.*;

public class UseCase10 {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }

        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}