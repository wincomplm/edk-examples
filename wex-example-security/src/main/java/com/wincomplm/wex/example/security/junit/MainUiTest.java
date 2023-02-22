package com.wincomplm.wex.example.security.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

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
    public void functional() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/security/call.jsp"); 
    }
    
    @Test
    public void security() throws Exception {
    }

}
