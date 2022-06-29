param(
    [Parameter()]
    [string]$user,   
    [Parameter()]
    [string]$pass,
    [Parameter()]
    [string]$wcserver,
    [Parameter()]
    [string]$file
)


# Install SharePoint Module
function Deploy-Windchill {
    $action = ($wcserver + '/netmarkets/jsp/com/wincomplm/wex/remote/control/wex.jsp?action=deploy')
    $pair = "$($user):$($pass)"
    $encodedCreds = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes($pair))
    $basicAuthValue = "Basic $encodedCreds"
    $Headers = @{
        Authorization = $basicAuthValue
    }
    Invoke-RestMethod -Uri $action -Method Post  -InFile $file -ContentType 'multipart/form-data' -Headers $Headers
}

try {
    Deploy-Windchill 
    exit 0
}
catch {
    Write-Output "$($_.Exception.Message)"
    exit 1
}