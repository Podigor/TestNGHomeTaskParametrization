import configuration.BaseClass;
import data.DataTestParam;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CertificatePage;
import pages.MainPage;

public class TestHomeTask extends BaseClass {
    static MainPage mainPage;
    static CertificatePage certificatePage;

    @BeforeClass
    public static void setupPages() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        certificatePage = PageFactory.initElements(driver, CertificatePage.class);
    }
    @Test
    public void checkCoursesMenuItemOnMainPage() {
       driver.get(mainPage.getMainPageUrl());
       Assert.assertTrue(mainPage.getCoursesMenuItem().isDisplayed());
    }
    @Test(dependsOnMethods = {"checkCoursesMenuItemOnMainPage"},
            dataProviderClass = DataTestParam.class, dataProvider = "getCertificatesAndExpectedResults")
    public void checkCertificate(String certificate, Boolean expectedResult) throws Exception {
        driver.get(certificatePage.getCertificatePageUrl());
        certificatePage.sendNumber(certificate);
        Assert.assertEquals(expectedResult,certificatePage.checkCertificateCheckForm());
    }



}
