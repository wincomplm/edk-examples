param(
    [Parameter()]
    [string]$SPVersion,
    [Parameter()]
    [string]$SPURL,
    [Parameter()]
    [string]$SPUsername,
    [Parameter()]
    [string]$SPPassword,
    [Parameter()]
    [string]$SPFolder,
    [Parameter()]
    [string]$Folder
)

# Write log Messages
function Write-Log {
    [CmdletBinding()]
    param(
        [Parameter()]
        [ValidateNotNullOrEmpty()]
        [string]$Message,

        [Parameter()]
        [ValidateNotNullOrEmpty()]
        [ValidateSet('Info', 'Warn', 'Error', 'Success')]
        [string]$Severity = 'Info'
    )

    $fgColor = "White"
    switch ($Severity) {
        Info {
            $fgColor = "White"
        }        
        Warn {  
            $fgColor = "Yellow"
        }
        Error {
            $fgColor = "Red"
        }
        Success {  
            $fgColor = "Green"
        }
    }
    Write-Host "$Message" -ForegroundColor $fgColor
}

# Install SharePoint Module
function Install-SharePoint {
    [CmdletBinding()]
    param(
        [Parameter(Mandatory = $true, HelpMessage = 'Online is for SharePoint Online, 2013 for SharePoint 2013, 2016 for SharePoint 2016 and 2019 for SharePoint 2019')]
        [ValidateNotNullOrEmpty()]
        [ValidateSet('Online', '2019', '2016', '2013')]
        [string]$Version = 'Online'
    )

    Write-Log -Severity Info -Message "Installing libraries for Sharepoint $($Version)"

    switch ($Version) {
        Online {
            if (!(Get-Module -ListAvailable -Name SharePointPnPPowerShellOnline)) {
                Install-Module SharePointPnPPowerShellOnline -SkipPublisherCheck -AllowClobber -Force
            }            
        }        
        2019 { 
            if (!(Get-Module -ListAvailable -Name SharePointPnPPowerShell2019)) { 
                Install-Module SharePointPnPPowerShell2019 -SkipPublisherCheck -AllowClobber -Force
            }
        }
        2016 {
            if (!(Get-Module -ListAvailable -Name SharePointPnPPowerShell2016)) {
                Install-Module SharePointPnPPowerShell2016 -SkipPublisherCheck -AllowClobber -Force
            }
        }
        2013 {
            if (!(Get-Module -ListAvailable -Name SharePointPnPPowerShell2013)) {  
                Install-Module SharePointPnPPowerShell2013 -SkipPublisherCheck -AllowClobber -Force
            }
        }
    }
}

# Upload files to SP
function Add-FilesToSP {
    [CmdletBinding()]
    param(
        [Parameter(Mandatory = $true, HelpMessage = 'Online is for SharePoint Online, 2013 for SharePoint 2013, 2016 for SharePoint 2016 and 2019 for SharePoint 2019')]
        [ValidateNotNullOrEmpty()]
        [ValidateSet('Online', '2019', '2016', '2013')]
        $Version,

        [Parameter(Mandatory = $true )]
        [ValidateNotNullOrEmpty()]
        [string]$URL,

        [Parameter(Mandatory = $true )]
        [ValidateNotNullOrEmpty()]
        [string]$Username,

        [Parameter(Mandatory = $true )]
        [ValidateNotNullOrEmpty()]
        $Password,

        [Parameter(Mandatory = $true )]
        [ValidateNotNullOrEmpty()]
        [string]$Folder,

        [Parameter(Mandatory = $true )]
        [ValidateNotNullOrEmpty()]
        [string]$SPFolder
    )

    Install-SharePoint -Version $Version
    Write-Log -Severity Info -Message "Connecting to SharePoint Site: $($URL)"

    [SecureString]$SecurePass = ConvertTo-SecureString $Password -AsPlainText -Force
    [System.Management.Automation.PSCredential]$PSCredentials = New-Object System.Management.Automation.PSCredential($Username, $SecurePass)

    try {
        $connection = Connect-PnPOnline -Url $URL -Credentials $PSCredentials
        if (-not (Get-PnPContext)) {
            Write-Log -Severity Error -Message "Error connecting to SharePoint Online, unable to establish context"
            return
        }

        Write-Log -Severity Info -Message "Uploading Files from $($Folder)"

        $filesToUpload = Get-ChildItem -Path $Folder  -Recurse 
        foreach ($file in $filesToUpload) {
            if ($file.PSIsContainer -ne $true) {
                try {
                    Write-Log -Severity Info -Message "Uploading $($file.FullName)"
                    Add-PnPFile -Path $file.FullName -Folder $SPFolder -Connection $connection
                }
                catch {
                    Write-Log -Severity Error -Message "Failed to upload: $($file.FullName) `n $($_.Exception.Message)"
                }
            }
        } 
    }
    catch {
        Write-Log -Severity Error -Message "Error connecting to SharePoint Online: $($_.Exception.Message)"
        return
    }
}

try {
    Add-FilesToSP -Version $SPVersion -Username $SPUsername -Password $SPPassword -URL $SPURL -SPFolder $SPFolder -Folder $Folder
    exit 0
}
catch {
    Write-Log -Message "$($_.Exception.Message)" -Severity Error
    exit 1
}