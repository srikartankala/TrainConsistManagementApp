import java.util.*;
import java.util.stream.*;

public class UseCase8main {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name,int capacity){
            this.name=name;
            this.capacity=capacity;
        }

        public String toString(){
            return name+" "+capacity;
        }
    }

    public static void main(String[] args){
        List<Bogie> bogies=new ArrayList<>();

        bogies.add(new Bogie("Sleeper",72));
        bogies.add(new Bogie("AC Chair",60));
        bogies.add(new Bogie("First Class",40));
        bogies.add(new Bogie("General",90));

        List<Bogie> filtered=bogies.stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);
    }
}