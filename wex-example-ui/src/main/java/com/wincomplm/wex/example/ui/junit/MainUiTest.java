package com.wincomplm.wex.example.ui.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
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

    @Test
    public void test() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/ui/index.jsp");
        driver.findElement(By.id("wex-ui-test-btn")).click();
        WebElement elem = driver.findElement(By.cssSelector(".jBox-content"));
        System.out.println("This is the text:" + elem.getText());
        
    }


}
