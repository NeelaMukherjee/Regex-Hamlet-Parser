import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {

        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        hamletParser.changeHamletToLeon();
        Assert.assertFalse(hamletParser.findHamlet(hamletParser.getHamletData()));
    }

    @Test
    public void testChangeHoratioToTariq() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletParser.findHoratio(hamletParser.getHamletData()));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        hamletParser.changeHoratioToTariq();
        Assert.assertFalse(hamletParser.findHoratio(hamletParser.getHamletData()));

    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        hamletParser.changeHamletToLeon();
        Assert.assertFalse(hamletParser.findHamlet(hamletParser.getHamletData()));
    }
}