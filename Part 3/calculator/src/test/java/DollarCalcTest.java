import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

@ExtendWith(MockitoExtension.class)
public class DollarCalcTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

   @Test
   public void testHello(){
       System.out.println("hello");
   }

   @Test
   public void dollarTest(){
       System.out.println("Hello world!");

       Calculator calculator = new Calculator(new KrwCalc());

       System.out.println(calculator.sum(10,10));

       MarketApi marketApi = new MarketApi();
       DollarCalc dollarCalc = new DollarCalc(marketApi);

       Calculator calculator1 = new Calculator(dollarCalc);

       System.out.println(calculator1.sum(10,10));
       Assertions.assertEquals(22000,calculator1.sum(10,10));
   }

    @Test
    public void mockTest(){


        DollarCalc dollarCalc = new DollarCalc(marketApi);
        dollarCalc.init();
        Calculator calculator = new Calculator(dollarCalc);

        System.out.println(calculator.sum(10,10));
        Assertions.assertEquals(60000,calculator.sum(10,10));
        Assertions.assertEquals(0,calculator.sum(10,10));
    }
}
