import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12Test {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type,String cargo){
            this.type=type;
            this.cargo=cargo;
        }
    }

    @Test
    void testSafety_AllBogiesValid(){
        List<GoodsBogie> list=new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical","Petroleum"));
        list.add(new GoodsBogie("Box","Coal"));
        boolean result=list.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));
        assertTrue(result);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo(){
        List<GoodsBogie> list=new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical","Coal"));
        boolean result=list.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));
        assertFalse(result);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed(){
        List<GoodsBogie> list=new ArrayList<>();
        list.add(new GoodsBogie("Open","Coal"));
        list.add(new GoodsBogie("Box","Grain"));
        boolean result=list.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));
        assertTrue(result);
    }

    @Test
    void testSafety_MixedBogiesWithViolation(){
        List<GoodsBogie> list=new ArrayList<>();
        list.add(new GoodsBogie("Cylindrical","Petroleum"));
        list.add(new GoodsBogie("Cylindrical","Coal"));
        boolean result=list.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));
        assertFalse(result);
    }

    @Test
    void testSafety_EmptyBogieList(){
        List<GoodsBogie> list=new ArrayList<>();
        boolean result=list.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));
        assertTrue(result);
    }
}