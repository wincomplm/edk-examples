package com.wincomplm.wex.example.testing.junit;

import org.junit.Test;
import com.wincomplm.wex.testplan.doc.annotations.TestDef;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Category;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Execution;

public class MainUiTest {

  
  
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
//        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/testing/edkHelloWorld.jsp");    
//        WebElement elem = driver.findElement(By.tagName("h1"));
//        assertEquals(elem.getText(), "Hello World");
    }
    
    @Test
    @TestDef(
        title = "Manual functional test",
        description = "This is a manual functional test",
        actions ="- Do this...<link>http://google.com</link>", 
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
