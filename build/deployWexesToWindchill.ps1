param(
    [Parameter()]
    [string]$user,   
    [Parameter()]
    [string]$pass,
    [Parameter()]
    [string]$wcserver,
    [Parameter()]
    [string]$dir
)


# Install SharePoint Module
function Deploy-Windchill {
    $action = ($wcserver + '/netmarkets/jsp/com/wincomplm/wex/orchestra/wex.jsp?action=deploy')
    $pair = "$($user):$($pass)"
    $encodedCreds = [System.Convert]::ToBase64String([System.Text.Encoding]::ASCII.GetBytes($pair))
    $basicAuthValue = "Basic $encodedCreds"
    $Headers = @{
        Authorization = $basicAuthValue
    }
    $files = Get-ChildItem $dir -Recurse | where {$_.extension -in @(".wex")}
    echo 'Deploying:'
    echo $files
    foreach ($file in $files) {
        Invoke-RestMethod -Uri $action -Method Post  -InFile $file.FullName -ContentType 'multipart/form-data' -Headers $Headers
    }
}

try {
    Deploy-Windchill
    exit 0
}
catch {
    Write-Output "$($_.Exception.Message)"
    exit 1
}