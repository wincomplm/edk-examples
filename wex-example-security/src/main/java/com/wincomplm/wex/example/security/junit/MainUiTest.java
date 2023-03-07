package com.wincomplm.wex.example.security.junit;

import com.wincomplm.wex.security.doc.annotations.TestDef.Category;
import com.wincomplm.wex.junit.impl.test.JunitTestAbstract;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import com.wincomplm.wex.security.doc.annotations.TestDef;
import com.wincomplm.wex.security.doc.annotations.TestDef.Execution;

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
        title = "Functional test 1",
        description = "This test will la la la<br/><br/>"
                + "- Step 1<br/>"
                + "- Step 2<br/>"
                + "- Step 3<br/>",
        category = Category.Functional,
        execution = Execution.Automatic
    )
    public void functional() throws Exception {
        driver.get(getAuthUrl() + "/netmarkets/jsp/com/wincomplm/wex/example/security/call.jsp");
    }

    @Test
    @TestDef(
            title = "Security test 1",
            description = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
            category = Category.Security,
            execution = Execution.Automatic
    )

    public void security() throws Exception {
    }

    @Test
    @TestDef(
            title = "Other test 1",
            description = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.",
            category = Category.Other,
            otherCategory = "Custom",
            execution = Execution.Automatic
    )

    public void other() throws Exception {
    }

}
