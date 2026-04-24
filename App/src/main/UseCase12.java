import java.util.*;
import java.util.stream.*;

public class UseCase12 {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type,String cargo){
            this.type=type;
            this.cargo=cargo;
        }
    }

    public static void main(String[] args){
        List<GoodsBogie> goodsBogies=new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical","Petroleum"));
        goodsBogies.add(new GoodsBogie("Box","Coal"));
        goodsBogies.add(new GoodsBogie("Open","Grain"));

        boolean isSafe=goodsBogies.stream()
                .allMatch(b->!b.type.equals("Cylindrical")||b.cargo.equals("Petroleum"));

        System.out.println(isSafe?"Train is Safe":"Train is Unsafe");
    }
}