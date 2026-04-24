import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8Test {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name,int capacity){
            this.name=name;
            this.capacity=capacity;
        }
    }

    List<Bogie> getSample(){
        List<Bogie> list=new ArrayList<>();
        list.add(new Bogie("Sleeper",72));
        list.add(new Bogie("AC Chair",70));
        list.add(new Bogie("First Class",40));
        list.add(new Bogie("General",90));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold(){
        List<Bogie> result=getSample().stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertEquals(2,result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold(){
        List<Bogie> result=getSample().stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertTrue(result.stream().noneMatch(b->b.capacity==70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold(){
        List<Bogie> result=getSample().stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertTrue(result.stream().noneMatch(b->b.capacity<70));
    }

    @Test
    void testFilter_MultipleBogiesMatching(){
        List<Bogie> result=getSample().stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertTrue(result.size()>1);
    }

    @Test
    void testFilter_NoBogiesMatching(){
        List<Bogie> list=new ArrayList<>();
        list.add(new Bogie("A",10));
        list.add(new Bogie("B",20));
        List<Bogie> result=list.stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching(){
        List<Bogie> list=new ArrayList<>();
        list.add(new Bogie("A",80));
        list.add(new Bogie("B",90));
        List<Bogie> result=list.stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertEquals(list.size(),result.size());
    }

    @Test
    void testFilter_EmptyBogieList(){
        List<Bogie> list=new ArrayList<>();
        List<Bogie> result=list.stream()
                .filter(b->b.capacity>70)
                .collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged(){
        List<Bogie> list=getSample();
        int originalSize=list.size();
        list.stream().filter(b->b.capacity>70).collect(Collectors.toList());
        assertEquals(originalSize,list.size());
    }
}