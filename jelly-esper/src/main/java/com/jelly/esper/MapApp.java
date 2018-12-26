package com.jelly.esper;

import com.espertech.esper.client.*;
import com.espertech.esper.util.CollectionUtil;
import com.jelly.esper.entity.Address;
import com.jelly.esper.entity.Child;
import com.jelly.esper.entity.Person;
import net.sf.cglib.core.CollectionUtils;

import java.util.*;

public class MapApp {
    public static void main(String[] args) {
        EPServiceProvider provider= EPServiceProviderManager.getDefaultProvider();
        EPAdministrator administrator=provider.getEPAdministrator();
        EPRuntime runtime=provider.getEPRuntime();
        Map<String,Object> person=new HashMap<String, Object>();
        person.put("name",String.class);
        person.put("age",int.class);
        person.put("children", List.class);
        person.put("address",Address.class);
        person.put("salary",double.class);

        administrator.getConfiguration().addEventType("Person",person);
        String epl="select name,age from Person";
        EPStatement statement=administrator.createEPL(epl);

        statement.addListener(new UpdateListener() {
            public void update(EventBean[] newEvents, EventBean[] oldEvents) {
                for (EventBean newEvent : newEvents) {
                    System.out.println(newEvent.get("name"));
                }
            }
        });
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name","1111");
        map.put("age",11);
        runtime.sendEvent(map,"Person");
        System.out.println(administrator.getConfiguration().getEventType("Person"));
    }
}
