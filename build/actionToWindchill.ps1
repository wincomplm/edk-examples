param(
    [Parameter()]
    [string]$user,   
    [Parameter()]
    [string]$pass,
    [Parameter()]
    [string]$wcserver,
    [Parameter()]
    [string]$action,
    [Parameter()]
    [string]$wexid
)


# Install SharePoint Module
function Deploy-Windchill {
    $url = ($wcserver + '/netmarkets/jsp/com/wincomplm/wex/remote/control/wex.jsp?action=' + $action + "&id=" + $wexid)
    $pair = "$($user):$($pass)"
    $encodedCreds = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes($pair))
    $basicAuthValue = "Basic $encodedCreds"
    $Headers = @{
        Authorization = $basicAuthValue
    }
    Invoke-RestMethod -Uri $url -Method Post -Headers $Headers
}

try {
    Deploy-Windchill 
    exit 0
}
catch {
    Write-Output "$($_.Exception.Message)"
    exit 1
}