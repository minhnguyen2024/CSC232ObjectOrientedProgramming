////////////////////////////////////////////////////////////////////////////////
// File:            MovingAverageTesting.java
// Course:          CSC 232 A, Spring 2021
// Authors:         Minh Nguyen
//
// Acknowledgments: None
//
// Online sources:  None
////////////////////////////////////////////////////////////////////////////////
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MovingAverageTesting {
    @Test
    public void MovingAverageTest0(){
        MovingAverage cma = MovingAverage.makeCumulative();
        MovingAverage sma10 = MovingAverage.makeSimple(10);
        MovingAverage sma1 = MovingAverage.makeSimple(1);

        for (int i = 1; i <= 100; i++) {
            cma.add(i);
            sma10.add(i);
            sma1.add(i);
        }
        
        assertEquals(50.5, cma.avg(), 0.001);
        assertEquals(95.5, sma10.avg(), 0.001);
        assertEquals(100.0, sma1.avg(),0.001);
        assertEquals(1, MovingAverage.min(), 0.001);
        assertEquals(100, MovingAverage.max(), 0.001);

        sma1.add(500);
        assertEquals(500.0, sma1.avg(), 0.001);
        assertEquals(500, MovingAverage.max());
    }

    @Test
    public void MovingAverageTest1(){
        MovingAverage cma = MovingAverage.makeCumulative();
        MovingAverage sma4 = MovingAverage.makeSimple(4);

        for (int i = 2; i <= 1000000; i++) {
        sma4.add(i);
        }
        cma.add(1);

        assertEquals(1.0,cma.avg(), 0.001);
        assertEquals(999998.5,sma4.avg(), 0.001);
        assertEquals(1,MovingAverage.min(), 0.001);
        assertEquals(1000000,MovingAverage.max(), 0.001);
    }

    @Test
    public void MovingAverageTest2(){
        MovingAverage cma1 = MovingAverage.makeCumulative();
        MovingAverage cma2 = MovingAverage.makeCumulative();

        for (int i = 2; i < 10; i ++){
        cma1.add(i);
        }
        assertEquals(2, MovingAverage.min());
        assertEquals(9, MovingAverage.max());

        for (int i = 4; i < 16; i++){
        cma2.add(i);
        }

        assertEquals(2, MovingAverage.min());
        assertEquals(15, MovingAverage.max());
    }

    @Test
    public void MovingAverageTest3(){
        MovingAverage scale = MovingAverage.makeScaled(2.5);

        for (int i = 1; i < 5; i++){
            scale.add(i);
        }

        assertEquals(6.0, scale.avg(), 0.0001);
        assertEquals(1, MovingAverage.min());
        assertEquals(4, MovingAverage.max());
    }
}
