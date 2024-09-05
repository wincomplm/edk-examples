package com.wincomplm.wex.example.security.junit;

import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import com.wincomplm.wex.testplan.doc.annotations.TestDef;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Category;
import com.wincomplm.wex.testplan.doc.annotations.TestDef.Execution;

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
    public void helloWorld() throws Exception {}
    

// -- Security --        
    @Test
    @TestDef(
        title = "WVE Review",
        description = "Example Review all WVES",
        actions ="- 501 - All back end access secure<br>"
               + "- 501 - global.jspf - Secure backend call only<br>"
               + "- 502 - ZipHelper.java - File creation secured<br>",
        category = TestDef.Category.Other,
        otherCategory = "Review",
        execution = TestDef.Execution.Manual,
        id = "S1"
    )
    public void reviewWVEs() throws Exception {
    }
      
    
    @Test
    @TestDef(
        title = "Security test 1",
        description = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
        category = Category.Security, 
        actions = "",
        result = "",
        execution = Execution.Manual,
        id = "S2"
    )
    public void security() throws Exception {}
    
    
    @TestDef(
        title = "Permissions Test",
        description = "The test will evaluate the role-based access control system in place. It will ensure that user roles are clearly defined, and permissions are associated with these roles. In this case, the focus is on the \"admin\" role and its exclusive access to the UI.",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S3",
        reference = "SEC-46"
    )
    @Test
    public void permissionsTest() throws Exception {

    }

    @TestDef(
        title = "Input Validation",
        description = "Test that validates and sanitizes input data received from request parameters to ensure it adheres to expected formats and ranges.",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S4",
        reference = "SEC-46"
    )
    @Test
    public void inputValidation() throws Exception {

    }

    @TestDef(
        title = "Request parameter test",
        description = "Calling xxx.jsp try to pass an oid that is not accessible by the current user ",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S5",
        reference = "SEC-46"
    )
    @Test
    public void requestParameterRundiagsTest() throws Exception {

    }

    @TestDef(
        title = "XSS test ",
        description = "Call xxx.jsp",
        result = "Ensure XSS security",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S6",
        reference = "SEC-46"
    )
    @Test
    public void xssRundiags() throws Exception {
    }

    @TestDef(
        title = "CSRF xxxxx.jsp test",
        description = "CSRF xxxxx.jsp test",
        result = "Ensure INVALID_NONCE is returned",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S7",
        reference = "SEC-46"
    )
    @Test
    public void csrfRundiags() throws Exception {
    }

    @TestDef(
        title = "Access xxxxx.jsp test",
        description = "Ensure that unauthorized users cannot access files by manipulating the file path.",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S8",
        reference = "SEC-46"
    )
    @Test
    public void accessxxxxx() throws Exception {
    }

    @TestDef(
        title = "Privilege escalation using session",
        description = "Ensure that unauthorized users cannot escalate privileges",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S9",
        reference = "SEC-46"
    )
    @Test
    public void privilegeEscalationSession() throws Exception {
    }

    @TestDef(
        title = "CSRF Do table action test",
        description = "Call xxxxx.jsp",
        actions ="- Do this",
        result =  "Ensure INVALID_NONCE is returned",
        category = Category.Security,
        execution = Execution.Manual,
        id = "S10",
        reference = "SEC-46"
      
    )
    @Test
    public void csrfTableAction() throws Exception {
    }


    @TestDef(
        title = "Do table action(param action) test",
        description = "Do table action(param action) test",
        actions = "Call xxxxx.jsp",
        result = "Ensure XSS security",
        category = Category.Security,
        execution = Execution.Manual,
        reference = "SEC-46",
        id = "S11"       
    )
    @Test
    public void TableActionParamAction() throws Exception {
    }

    @TestDef(
        title = "FormProcessor param test",
        description = "FormProcessor param test",
        actions = "Call FormProcessor",
        result = "Ensure XSS security",
        category = Category.Security,
        execution = Execution.Manual,
        reference = "SEC-46",
        id = "S12"    
    )
    @Test
    public void FormProcessor() throws Exception {
    }
    
    @TestDef(
        title = "Create escalation privilege test ",
        description = "Ensure that unauthorized users cannot escalate privileges",
        category = Category.Security,
        execution = Execution.Manual,
        reference = "SEC-46",
        id = "S13"   
    )
    @Test
    public void DocumentCreatorPrivilegeEscalation() throws Exception {
    }
    

}
