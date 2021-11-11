### FAKE Configuration

#### Distribution

![file]({{package-images}}/image-1572955612331.png)

| Option | Description |
| ------ | ----------- |
| **Email Recipients** | List of all the recipients of the email. If this is set, Role email Recipients will be ignored |
| **Email from address** | The address shown as the sender of the email |
| **Email Subject** | The subject of the Email |
| **Email Recipients with specific role** | Select a role to email all of its members. If email Recipients is set, this option will be ignored |
| **Send Email** | Choose wether the email should be sent for workflow and listener (UI choice overrides this setting) |
| **Create Document** | Choose wether the document should be created for workflow and listener (UI choice overrides this setting) |

#### Generated Document

![file]({{package-images}}/image-1572955619999.png)

| Option | Description |
| ------ | ----------- |
| **Container of the generated Document** | The container that will contain the enerated Document |
| **Folder of the generated Document** | The folder that will contain the generated Document |
| **Type of the generated Document** | The type that the generated Document will have |
| **Use default Document number** | Use this option if the custom OIR that is used does not create a number for the Document |

#### Collector 

| Option                                     | Description                                                  |
| ------------------------------------------ | ------------------------------------------------------------ |
| **Max number of children to be collected** | If the amount of bom children collected goes past this count no further children will be collected |
| **Part child states**                      | When the user collects in the UI the structure only these states will be selected (the view will also match) |

