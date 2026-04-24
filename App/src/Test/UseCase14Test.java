import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14Test {

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

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException{
        PassengerBogie b=new PassengerBogie("Sleeper",50);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException(){
        Exception ex=assertThrows(InvalidCapacityException.class,()->{
            new PassengerBogie("Sleeper",-10);
        });
        assertEquals("Capacity must be greater than zero",ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException(){
        Exception ex=assertThrows(InvalidCapacityException.class,()->{
            new PassengerBogie("Sleeper",0);
        });
        assertEquals("Capacity must be greater than zero",ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation(){
        Exception ex=assertThrows(InvalidCapacityException.class,()->{
            new PassengerBogie("AC",0);
        });
        assertEquals("Capacity must be greater than zero",ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException{
        PassengerBogie b=new PassengerBogie("AC",60);
        assertEquals("AC",b.type);
        assertEquals(60,b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException{
        PassengerBogie b1=new PassengerBogie("Sleeper",70);
        PassengerBogie b2=new PassengerBogie("AC",80);
        assertNotNull(b1);
        assertNotNull(b2);
    }
}