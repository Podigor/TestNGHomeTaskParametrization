package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificatePage {
    final String certificatePageUrl = "https://certificate.ithillel.ua/";

    public String getCertificatePageUrl() {
        return certificatePageUrl;
    }

    @FindBy(name="certificate")
    WebElement searchField;

    @FindBy(xpath = "//p[@class='certificate-check_message']")
    WebElement checkFormMessage;

    WebDriver driver;

    public CertificatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendNumber(String number) {
        searchField.sendKeys(number);
        searchField.sendKeys(Keys.ENTER);
    }

    private boolean checkLinkCertificate() {
        return driver.getCurrentUrl().contains("view");
    }

    public boolean checkCertificateCheckForm() throws Exception {
        int i = 0;
        boolean result;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMessage.getText().contains("Сертифікат не знайдено")) {
                result = false;
                break;
            }
            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Waiting time is run out");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
