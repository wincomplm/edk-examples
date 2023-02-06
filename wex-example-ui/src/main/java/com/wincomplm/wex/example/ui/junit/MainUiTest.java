package com.wincomplm.wex.example.ui.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;

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
        driver.get("http://wcadmin:wcadmin@beauty.ptc.com/Windchill/netmarkets/jsp/com/wincomplm/wex/example/ui/index.jsp");
        driver.findElement(By.id("wex-ui-test-btn")).click();
    }
}
