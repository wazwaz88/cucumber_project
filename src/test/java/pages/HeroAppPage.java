package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HeroAppPage {


    public HeroAppPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "li>a")
    public List<WebElement> categoryLinks;

    @FindBy(css = "#content>h3")
    public WebElement addRemoveHeading3;

    @FindBy(xpath = "//button")
    public WebElement addElementButton;

    @FindBy(xpath = "//button[@class=\"added-manually\"]")
    public WebElement deleteElementButton;

    @FindBy(css = ".example>h3")
    public WebElement contextMenuHeading3;

    @FindBy(css = ".example>p:nth-child(2)")
    public WebElement paragraph1;

    @FindBy(css = ".example>p:nth-child(3)")
    public WebElement paragraph2;

    @FindBy(id = "hot-spot")
    public WebElement rectangleBox;


    public void clickOnCategoryLink(String linkText) {
        for (WebElement link : categoryLinks) {
            if (link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }

    }
}
