param(
    [Parameter()]
    [string]$user,   
    [Parameter()]
    [string]$pass,
    [Parameter()]
    [string]$wcserver,
    [Parameter()]
    [string]$junitpath # example: "wex/example/ui"
)


# Run Junit Tests
function JUnit-Windchill {
    $pair = "$($user):$($pass)"
    $encodedCreds = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes($pair))
    $basicAuthValue = "Basic $encodedCreds"
    $Headers = @{
        Authorization = $basicAuthValue
    }
    # POST Request to trigger jUnit testing
    $testUrl = ($wcserver + "/netmarkets/jsp/com/wincomplm/" + $junitpath + "/junit.jsp?auth=" + $pair) 
    $response = Invoke-RestMethod -Uri $testUrl -Method Post -ContentType 'multipart/form-data' -Headers $Headers
    echo "jUnit testing results:"
    echo $response
    # Return jUnit test results to pipeline
    if ($response.failureCount -eq 0) {
        echo 'All jUnit tests passed successfully.'
    } else {
        throw "jUnit testing failed: see results above for details."
    }
}

try {
    JUnit-Windchill
    exit 0
}
catch {
    Write-Output "$($_.Exception.Message)"
    exit 1
}