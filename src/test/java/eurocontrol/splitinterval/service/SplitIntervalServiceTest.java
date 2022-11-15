package eurocontrol.splitinterval.service;

import eurocontrol.splitinterval.model.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SplitIntervalServiceTest {

    private SplitIntervalService service;

    @Before
    public void setUp() {
        service = new SplitIntervalService();
    }

    @Test
    public void splitInterval_scenario1() {
        List<Interval> input = Arrays.asList(new Interval(0,100));
        Interval interval = new Interval(20,30);
        List<Interval> expectedResult = Arrays.asList(new Interval(0,19),new Interval(20,30),new Interval(31,100));

        Assert.assertArrayEquals(expectedResult.toArray(),service.splitInterval(input,interval).toArray());
    }

    @Test
    public void splitInterval_scenario2() {
        List<Interval> input = Arrays.asList(new Interval(0,19),new Interval(20,30),new Interval(31,100));
        Interval interval = new Interval(25,50);
        List<Interval> expectedResult = Arrays.asList(new Interval(0,19),new Interval(20,24),new Interval(25,50),new Interval(51,100));

        Assert.assertArrayEquals(expectedResult.toArray(),service.splitInterval(input,interval).toArray());
    }
    @Test
    public void splitInterval_scenario3() {
        List<Interval> input = Arrays.asList(new Interval(0,100));
        Interval interval = new Interval(25,50);
        List<Interval> expectedResult = Arrays.asList(new Interval(0,24),new Interval(25,50),new Interval(51,100));

        Assert.assertArrayEquals(expectedResult.toArray(),service.splitInterval(input,interval).toArray());
    }
    @Test
    public void splitInterval_scenario4() {
        List<Interval> input = Arrays.asList(new Interval(0,24),new Interval(25,50),new Interval(51,100));
        Interval interval = new Interval(25,70);
        List<Interval> expectedResult = Arrays.asList(new Interval(0,24),new Interval(25,70),new Interval(71,100));

        Assert.assertArrayEquals(expectedResult.toArray(),service.splitInterval(input,interval).toArray());
    }
    @Test
    public void splitInterval_scenario5() {
        List<Interval> input = Arrays.asList(new Interval(0,24),new Interval(25,50),new Interval(51,100));
        Interval interval = new Interval(24,70);
        List<Interval> expectedResult = Arrays.asList(new Interval(0,23),new Interval(24,70),new Interval(71,100));

        Assert.assertArrayEquals(expectedResult.toArray(),service.splitInterval(input,interval).toArray());
    }
}