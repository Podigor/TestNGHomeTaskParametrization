package data;

import org.testng.annotations.DataProvider;

public class DataTestParam {
    @DataProvider
    public static Object[][] getCertificatesAndExpectedResults(){
        return new Object[][]{
                {"1236547898", false},
                {"45924126", true},
                {"45665856145", false},
        };
    }
}
