package pages;

import org.openqa.selenium.support.PageFactory;

public class inicioPage {

    public inicioPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
