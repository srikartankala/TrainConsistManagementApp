import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13Test {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type,int capacity){
            this.type=type;
            this.capacity=capacity;
        }
    }

    List<Bogie> getData(){
        List<Bogie> list=new ArrayList<>();
        list.add(new Bogie("A",50));
        list.add(new Bogie("B",70));
        list.add(new Bogie("C",80));
        list.add(new Bogie("D",40));
        return list;
    }

    @Test
    void testLoopFilteringLogic(){
        List<Bogie> list=getData();
        List<Bogie> result=new ArrayList<>();
        for(Bogie b:list){
            if(b.capacity>60){
                result.add(b);
            }
        }
        assertEquals(2,result.size());
    }

    @Test
    void testStreamFilteringLogic(){
        List<Bogie> result=getData().stream()
                .filter(b->b.capacity>60)
                .collect(Collectors.toList());
        assertEquals(2,result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch(){
        List<Bogie> list=getData();

        List<Bogie> loop=new ArrayList<>();
        for(Bogie b:list){
            if(b.capacity>60){
                loop.add(b);
            }
        }

        List<Bogie> stream=list.stream()
                .filter(b->b.capacity>60)
                .collect(Collectors.toList());

        assertEquals(loop.size(),stream.size());
    }

    @Test
    void testExecutionTimeMeasurement(){
        List<Bogie> list=getData();

        long start=System.nanoTime();
        list.stream().filter(b->b.capacity>60).collect(Collectors.toList());
        long end=System.nanoTime();

        assertTrue((end-start)>0);
    }

    @Test
    void testLargeDatasetProcessing(){
        List<Bogie> list=new ArrayList<>();
        for(int i=0;i<10000;i++){
            list.add(new Bogie("T",i%100));
        }

        List<Bogie> result=list.stream()
                .filter(b->b.capacity>60)
                .collect(Collectors.toList());

        assertNotNull(result);
    }
}