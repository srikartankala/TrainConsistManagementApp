import org.junit.jupiter.api.Test;
import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11Test {

    private boolean isValidTrain(String id) {
        return Pattern.compile("TRN-\\d{4}").matcher(id).matches();
    }

    private boolean isValidCargo(String code) {
        return Pattern.compile("PET-[A-Z]{2}").matcher(code).matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrain("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrain("TRAIN12"));
        assertFalse(isValidTrain("TRN12A"));
        assertFalse(isValidTrain("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargo("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargo("PET-ab"));
        assertFalse(isValidCargo("PET123"));
        assertFalse(isValidCargo("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrain("TRN-123"));
        assertFalse(isValidTrain("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargo("PET-Ab"));
        assertFalse(isValidCargo("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrain(""));
        assertFalse(isValidCargo(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrain("TRN-1234X"));
        assertFalse(isValidCargo("XPET-AB"));
    }
}