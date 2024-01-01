## User Guide

Please refer to the [documentation](https://docs.wex.solutions/#e17-example-security)

### UI Implementation

There are two main UI pages

[Hello World](netmarkets/jsp/com/wincomplm/wex/example/security/edkHelloWorld.jsp)

Which is an admin only page and will be rejected for other users.

[Secure Test](netmarkets/jsp/com/wincomplm/wex/example/security/edkSecureTest.jsp)

Performs sanitization to ensure there is no path disclosure or XSS 

[Junit Testing](netmarkets/jsp/com/wincomplm/wex/example/security/junit.jsp?pretty=true)

Runs all the Junit tests
