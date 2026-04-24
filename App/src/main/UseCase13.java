import java.util.*;
import java.util.stream.*;

public class UseCase13 {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type,int capacity){
            this.type=type;
            this.capacity=capacity;
        }
    }

    public static void main(String[] args){
        List<Bogie> bogies=new ArrayList<>();

        for(int i=0;i<100000;i++){
            bogies.add(new Bogie("Type"+i,i%100));
        }

        long startLoop=System.nanoTime();
        List<Bogie> loopResult=new ArrayList<>();
        for(Bogie b:bogies){
            if(b.capacity>60){
                loopResult.add(b);
            }
        }
        long endLoop=System.nanoTime();

        long startStream=System.nanoTime();
        List<Bogie> streamResult=bogies.stream()
                .filter(b->b.capacity>60)
                .collect(Collectors.toList());
        long endStream=System.nanoTime();

        System.out.println("Loop Time: "+(endLoop-startLoop));
        System.out.println("Stream Time: "+(endStream-startStream));
        System.out.println("Loop Size: "+loopResult.size());
        System.out.println("Stream Size: "+streamResult.size());
    }
}

