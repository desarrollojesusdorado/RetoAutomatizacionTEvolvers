package userinterface.demoblaze;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddProductsPage {

    public static final Target PRODCUTS = Target.the("").located(By.xpath("//div[@id='tbodyid']/div/div/div/h4"));
    public static final Target PARAMETER_PRODCUTS = Target.the("{0} name Product").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target ADD_TO_CART = Target.the("").located(By.xpath("//*[@id='tbodyid']/div[2]/div/a"));
    public static final Target HOME = Target.the("").located(By.xpath("//*[@id='navbarExample']/ul/li[1]/a"));
    public static final Target OBJECT = Target.the("").located(By.xpath("//*[@id='cat']"));
    public static final Target CART = Target.the("").located(By.id("cartur"));

}
