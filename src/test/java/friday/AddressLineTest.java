package friday;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddressLineTest {

    private static AddressParser addressParser = null;

    @BeforeClass
    public static void setUp(){
        addressParser = new AddressParser();
    }

    @Test
    public void testCase1(){
        String address = "Winterallee 3";
        ParsedAddress expected = new ParsedAddress("Winterallee", "3");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2(){
        String address = "Musterstrasse 45";
        ParsedAddress expected = new ParsedAddress("Musterstrasse", "45");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3(){
        String address = "Blaufeldweg 123B";
        ParsedAddress expected = new ParsedAddress("Blaufeldweg", "123B");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4(){
        String address = "Am Bächle 23";
        ParsedAddress expected = new ParsedAddress("Am Bächle", "23");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase5(){
        String address = "Auf der Vogelwiese, 23 b";
        ParsedAddress expected = new ParsedAddress("Auf der Vogelwiese", "23 b");

        ParsedAddress actual = addressParser.parse(address);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase6(){
        String address = "4, rue de la revolution";
        ParsedAddress expected = new ParsedAddress("rue de la revolution", "4");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase7(){
        String address = "200 Broadway Av";
        ParsedAddress expected = new ParsedAddress("Broadway Av", "200");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase8(){
        String address = "Calle Aduana, 29";
        ParsedAddress expected = new ParsedAddress("Calle Aduana", "29");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase9(){
        String address = "Calle 39, No 1540";
        ParsedAddress expected = new ParsedAddress("Calle 39", "No 1540");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase10(){
        String address = "No 1540, Calle 39";
        ParsedAddress expected = new ParsedAddress("Calle 39", "No 1540");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase11(){
        String address = "4 b, rue de la revolution";
        ParsedAddress expected = new ParsedAddress("rue de la revolution", "4 b");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase12(){
        String address = "200G Broadway Av";
        ParsedAddress expected = new ParsedAddress("Broadway Av", "200G");
        ParsedAddress actual = addressParser.parse(address);
        Assert.assertEquals(expected, actual);
    }
}
