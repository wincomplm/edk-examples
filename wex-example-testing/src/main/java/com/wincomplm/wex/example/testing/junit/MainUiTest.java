package com.wincomplm.wex.example.testing.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import com.wincomplm.wex.testplan.doc.annotations.TestDef;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Category;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Execution;
import static org.junit.Assert.assertEquals;
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
  
  
// -- Functional --  
   
    @Test
    @TestDef(
        title = "Hello World Test",
        description = "This an auto test of a basic Hello World page",
        actions ="- Do this<br>" 
                + "- Do that<br>"
                + "<image>hellomenu.png</image>",
        result ="It works <image>helloworld.png</image>",
        category = Category.Functional,
        execution = Execution.Automatic,
        id = "1"

    )
    public void helloWorld() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/testing/edkHelloWorld.jsp");    
        WebElement elem = driver.findElement(By.tagName("h1"));
        assertEquals(elem.getText(), "Hello World");
    }
    
    @Test
    @TestDef(
        title = "Manual functional test",
        description = "This is a manual functional test",
        actions ="- Do this>", 
        result ="This is the result <image>result.png</image>",
        category = Category.Other,
        otherCategory = "Custom",
        execution = Execution.Manual,
        id = "2"
    )
    public void manualTest() throws Exception {}

// -- Security --        
// We should add security tests here
       
    
    

}
