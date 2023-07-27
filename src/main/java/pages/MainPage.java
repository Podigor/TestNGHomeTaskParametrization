package pages;

import configuration.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseClass {
    final String mainPageUrl = "https://ithillel.ua/";

    @FindBy(xpath = "//button[@data-dropdown-trigger=\"coursesMenu\"]")
    private WebElement coursesMenuItem;

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public WebElement getCoursesMenuItem() {
        return coursesMenuItem;
    }
}
