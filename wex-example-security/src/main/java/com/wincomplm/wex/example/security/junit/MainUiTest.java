package com.wincomplm.wex.example.security.junit;

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
  
    @Test
    @TestDef(
        title = "WVE Review",
        description = "Example Review all WVES<br><br>",
        actions ="- 501 - All back end access secure<br>"
            + "- 501 - global.jspf - Secure backend call only<br>"
            + "- 502 - ZipHelper.java - File creation secured<br>",
        category = TestDef.Category.Other,
        otherCategory = "Review",
        execution = TestDef.Execution.Manual
    )
    public void reviewWVEs() throws Exception {
    }
    
   
    @Test
    @TestDef(
        title = "Hello World Test",
        description = "This an auto test of a basic Hello World page<br/>",
        actions ="- Do this<br>" 
                + "- Do that<br>"
                + "<image>hellomenu.png</image>",
        result ="It works <image>helloworld.png</image>",
        category = Category.Functional,
        execution = Execution.Automatic
    )
    public void helloWorld() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/security/edkHelloWorld.jsp");    
        WebElement elem = driver.findElement(By.tagName("h1"));
        assertEquals(elem.getText(), "Hello World");
    }
    
    @Test
    @TestDef(
        title = "Secure Test",
        description = "This an auto test of a secure request<br/>",
        category = Category.Functional,
        execution = Execution.Automatic
    )
    public void secureUITest() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/security/edkSecureTest.jsp");    
        WebElement elem = driver.findElement(By.tagName("body"));
        assertEquals(elem.getText(), "javascript could be here, or a path [NOT DISCLOSED]");
    }
    
    

    @Test
    @TestDef(
            title = "Security test 1",
            description = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
            category = Category.Security,
            execution = Execution.Manual
    )

    public void security() throws Exception {
    }

    @Test
    @TestDef(
            title = "Other test 1",
                description = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.",
            category = Category.Other,
            otherCategory = "Custom",
            execution = Execution.Manual
    )

    public void other() throws Exception {
    }

    @TestDef(
            title = "Permissions Test",
            description = "The test will evaluate the role-based access control system in place. It will ensure that user roles are clearly defined, and permissions are associated with these roles. In this case, the focus is on the \"admin\" role and its exclusive access to the UI.",
            category = Category.Security,
            execution = Execution.Manual,
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
            reference = "SEC-46"
    )
    @Test
    public void requestParameterRundiagsTest() throws Exception {

    }

    @TestDef(
            title = "XSS test ",
            description = "Call xxx.jsp <br>"
            + "Ensure XSS security<br>",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void xssRundiags() throws Exception {
    }

    @TestDef(
            title = "CSRF xxxxx.jsp test",
            description = "Ensure INVALID_NONCE is returned<br>"
            + "xxxx.jsp",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void csrfRundiags() throws Exception {
    }


    @TestDef(
            title = "Access xxxxx.jsp test",
            description = "Ensure that unauthorized users cannot access files by manipulating the file path.<br>"
            + "xxxxx.jsp",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void accessxxxxx() throws Exception {
    }

    @TestDef(
            title = "Privilege escalation using session",
            description = "Ensure that unauthorized users cannot escalate privileges.<br>"
            + "DocumentCreator",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void privilegeEscalationSession() throws Exception {
    }

    @TestDef(
            title = "CSRF Do table action test",
            description = "Call xxxxx.jsp<br>"
            + "Ensure INVALID_NONCE is returned<br>",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void csrfTableAction() throws Exception {
    }


    @TestDef(
            title = " Do table action(param action) test",
            description = "Call xxxxx.jsp<br>"
            + "Ensure XSS security<br>",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void TableActionParamAction() throws Exception {
    }

    @TestDef(
            title = "FormProcessor param test ",
            description = "Call FormProcessor<br>"
            + "Ensure XSS security<br>",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void FormProcessor() throws Exception {
    }
     @TestDef(
            title = "Create escalation privilege test ",
            description = "Ensure that unauthorized users cannot escalate privileges",
            category = Category.Security,
            execution = Execution.Manual,
            reference = "SEC-46"
    )
    @Test
    public void DocumentCreatorPrivilegeEscalation() throws Exception {
    }
    
    

}
