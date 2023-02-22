<wex-security>
    <approval>
        <review>
            <name>Ellis Douglas/name>
            <date>2023-2-20</date>
        </review>
        <approved>             
            <name>Simon Heath</name>
            <date>2023-2-20</date>
        </approved>
    </approval>
    <level>B</level>
    <assessments>
        <level value="A">
            <assessment>
                <desc>Offers services to other systems</desc> 
                <valid>false</valid> 
            </assessment>
        </level>
        <level value="B">
            <assessment>
                <desc></desc> 
                <valid>false</valid> 
            </assessment>
        </level>
        <level value="C">
            <assessment>
                <desc></desc> 
                <valid>false</valid> 
            </assessment>
        </level>
    </assessments>
</wex-security>

## Details

**Date/Time:** ${datetime}
**Group ID:** ${groupId}
**Artificate ID:** ${artifactId}
**Reviewed By:** Mickey
**Authorised By:** Donald

## Security Level

### Security Level: B

+ Offers services to other systems: [ No ] [A]
+ Server to server with other systems: [ No ] [A]
+ Browser based communication with other systems: [ YNo ] [A]
+ Stores and manages credentials: [ No ] [A]
+ Any direct database access: [ No ] [A]

+ Escalation privilage access to Windchill: [ Yes ] [B]
+ Administration Only UIs: [ Yes ] [B]
+ Direct access UIs e.g. downloads: [ No ] [B]
+ Requires XSS/CSRF testing: [ Yes ] [B]

+ Implements a Windchill UI: [ Yes ] [C]



