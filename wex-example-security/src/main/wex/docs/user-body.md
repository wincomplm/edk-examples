## User Guide

Please refer to the [documentation](https://docs.wex.solutions/#e17-example-security)

### UI Implementation

There are two main UI pages

[Hello World](netmarkets/jsp/com/wincomplm/wex/example/security/edkHelloWorld.jsp)

Which is an admin only page and will be rejected for other users.

[XSS Test](netmarkets/jsp/com/wincomplm/wex/example/security/xssTest.jsp?id=<img%20src=1%20href=1%20onerror="javascript:alert(1)"></img>)

A page that triggers an XSS failure, it will alert 1 on the browser

[Junit Testing](netmarkets/jsp/com/wincomplm/wex/example/security/junit.jsp?pretty=true)

Runs all the Junit tests
