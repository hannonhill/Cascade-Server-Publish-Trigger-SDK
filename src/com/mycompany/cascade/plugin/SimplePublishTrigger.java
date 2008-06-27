/*
 * Created on Jan 17, 2008 by Zach Bailey
 *
 * This software is offered as-is with no license and is free to reproduce or use as anyone sees fit.
 */
package com.mycompany.cascade.plugin;

import java.util.HashMap;
import java.util.Map;

import com.cms.publish.PublishTrigger;
import com.cms.publish.PublishTriggerEntityTypes;
import com.cms.publish.PublishTriggerException;
import com.cms.publish.PublishTriggerInformation;

/**
 * This plug-in does some really neat stuff!
 * @author <Your Name Here>
 */
public class SimplePublishTrigger implements PublishTrigger
{
    private Map<String, String> parameters = new HashMap<String, String>();
    private PublishTriggerInformation information;
    
    /* (non-Javadoc)
     * @see com.cms.publish.PublishTrigger#invoke()
     */
    public void invoke() throws PublishTriggerException
    {
        // this is where the logic for the trigger lives.
        // we switch on the entity type and this allows us to determine if a page or file is being published
        switch (information.getEntityType())
        {
            case PublishTriggerEntityTypes.TYPE_FILE:
                System.out.println("Publishing file with path " + information.getEntityPath() + " and id " + information.getEntityId());
                break;
            case PublishTriggerEntityTypes.TYPE_PAGE:
                System.out.println("Publishing page with path " + information.getEntityPath() + " and id " + information.getEntityId());
                break;
        }
    }

    /* (non-Javadoc)
     * @see com.cms.publish.PublishTrigger#setParameter(java.lang.String, java.lang.String)
     */
    public void setParameter(String name, String value)
    {
        // let's just store our parameters in a Map for access later
        parameters.put(name, value);
    }

    /* (non-Javadoc)
     * @see com.cms.publish.PublishTrigger#setPublishInformation(com.cms.publish.PublishTriggerInformation)
     */
    public void setPublishInformation(PublishTriggerInformation information)
    {
        // store this in an instance member so invoke() has access to it
        this.information = information;
    }
}
