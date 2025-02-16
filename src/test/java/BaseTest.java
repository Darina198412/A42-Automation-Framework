import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class BaseTest {
    private final BasePage basePage = new BasePage();   // это конструктор который будет вызывать BasePage
    public String url = "https://bbb.testpro.io/";


     @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        basePage.initBrowser(url);
    }

     @AfterMethod(alwaysRun = true)
    public void tearDown() {
         basePage.closeBrowser();
     }

    public BasePage getBasePage() {   // это это намнужно чтобы мы могли получить driver когда нам нужно
        return basePage;
    }
}