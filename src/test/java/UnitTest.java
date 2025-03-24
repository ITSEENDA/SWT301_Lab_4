import org.example.swt301_lab_4.CommissionCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTest {

//    @Test
//    void constructor0(){
//        var calculator = new CommissionCalculator();
//        Assertions.assertNotNull(calculator);
//    }

    @Test
    void calculateCommissionCase1() {
        boolean isSalaried = false;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 0D;
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice)
        );
        Assertions.assertEquals(CommissionCalculator.EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void calculateCommissionCase2() {
        boolean isSalaried = false;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.GENERAL;
        double itemPrice = 10000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, itemPrice * 0.1D);
    }

    @Test
    void calculateCommissionCase3() {
        boolean isSalaried = false;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.GENERAL;
        double itemPrice = 100000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, itemPrice * 0.05D);
    }

    @Test
    void calculateCommissionCase4() {
        boolean isSalaried = true;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.STANDARD;
        double itemPrice = 1000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, 0D);
    }

    @Test
    void calculateCommissionCase5() {
        boolean isSalaried = false;
        boolean isRegularCustomer = true;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 10000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, 0D);
    }

    @Test
    void calculateCommissionCase6() {
        boolean isSalaried = true;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 1000F;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, itemPrice * 0.05D);
    }

    @Test
    void calculateCommissionCase7() {
        boolean isSalaried = true;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 10000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, 25D);
    }

    @Test
    void calculateCommissionCase8() {
        boolean isSalaried = false;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 1000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, itemPrice * 0.1D);
    }

    @Test
    void calculateCommissionCase9() {
        boolean isSalaried = false;
        boolean isRegularCustomer = false;
        String itemType = CommissionCalculator.BONUS;
        double itemPrice = 10000D;
        double commission = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
        Assertions.assertEquals(commission, 75D);
    }
}