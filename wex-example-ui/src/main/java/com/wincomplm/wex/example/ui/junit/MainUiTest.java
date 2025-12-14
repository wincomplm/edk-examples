package com.wincomplm.wex.example.ui.junit;

import com.wincomplm.wex.testplan.doc.annotations.TestDef;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Category;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Execution;
import org.junit.Test;


public class MainUiTest  {


    @TestDef(
            title = "Simple UI test",
            description = "Simple UI test<br/>",
            category = Category.Functional,
            execution = Execution.Automatic
    )
    @Test
    public void test() throws Exception {
//        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/ui/index3.jsp");
//        driver.findElement(By.id("wex-ui-test-btn")).click();
//        WebElement elem = driver.findElement(By.cssSelector(".jBox-content"));
//        System.out.println("This is the text:" + elem.getText());
        
    }


}
