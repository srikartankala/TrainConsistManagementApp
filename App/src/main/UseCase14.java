import java.util.*;

public class UseCase14{

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message){
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type,int capacity) throws InvalidCapacityException{
            if(capacity<=0){
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type=type;
            this.capacity=capacity;
        }
    }

    public static void main(String[] args){
        try{
            PassengerBogie b1=new PassengerBogie("Sleeper",72);
            PassengerBogie b2=new PassengerBogie("AC",0);
            System.out.println(b1.type+" "+b1.capacity);
            System.out.println(b2.type+" "+b2.capacity);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
