package userinterface.demoblaze;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    public static final Target PLACE_ORDER = Target.the("").located(By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
    public static final Target NAME = Target.the("").located(By.id("name"));
    public static final Target COUNTRY = Target.the("").located(By.id("country"));
    public static final Target CITY = Target.the("").located(By.id("city"));
    public static final Target CREDIT_CARD = Target.the("").located(By.id("card"));
    public static final Target MONTH = Target.the("").located(By.id("month"));
    public static final Target YEAR = Target.the("").located(By.id("year"));
    public static final Target PURCHASE = Target.the("").located(By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]"));
    public static final Target MESSAGE = Target.the("").located(By.xpath("//*[contains(text(),'Thank you for your purchase!')]"));
    public static final Target TOTAL_PRICE = Target.the("").located(By.xpath("//*[@id=\"totalp\"]"));

}
