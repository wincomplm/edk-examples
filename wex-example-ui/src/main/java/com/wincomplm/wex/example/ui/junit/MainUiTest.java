package com.wincomplm.wex.example.ui.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import com.wincomplm.wex.security.doc.annotations.TestDef;
import com.wincomplm.wex.security.doc.annotations.TestDef.Category;
import com.wincomplm.wex.security.doc.annotations.TestDef.Execution;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainUiTest extends JunitTestAbstract {


    @Before
    public void setUp() {
        super.setUp();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

    @TestDef(
            title = "Simple UI test",
            description = "Simple UI test<br/>",
            category = Category.Functional,
            execution = Execution.Automatic
    )
    @Test
    public void test() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/ui/index.jsp");
        driver.findElement(By.id("wex-ui-test-btn")).click();
        WebElement elem = driver.findElement(By.cssSelector(".jBox-content"));
        System.out.println("This is the text:" + elem.getText());
        
    }


}
