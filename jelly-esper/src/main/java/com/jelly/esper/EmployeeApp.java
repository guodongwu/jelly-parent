package com.jelly.esper;

import com.espertech.esper.client.*;
import com.jelly.esper.entity.Address;
import com.jelly.esper.entity.Child;
import com.jelly.esper.entity.Employee;
import com.jelly.esper.entity.Person;
import com.jelly.esper.listener.EmployeeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EmployeeApp {
    public static void main(String[] args) {
        EPServiceProvider epServiceProvider= EPServiceProviderManager.getDefaultProvider();
        EPAdministrator administrator=epServiceProvider.getEPAdministrator();
        String model= Employee.class.getName();
        String epl="select name,salary,avg(salary) salary_avg,age, avg(age) age_avg from "+model
                +".win:length(5)";//length  length_batch time time_batch根据处理数量计算
        EPStatement statement=administrator.createEPL(epl);
        statement.addListener(new EmployeeListener());
        EPRuntime runtime=epServiceProvider.getEPRuntime();

        for (int i=0;i<10;i++){
            Employee employee=new Employee();
            employee.setName("emp"+i);
            employee.setAge(20+i);
            employee.setSalary(2000+i*1000);
            runtime.sendEvent(employee);
        }
        List<Employee> employees=EmployeeListener.employees;
        if(!employees.isEmpty()){
            employees.forEach(s-> System.out.println(s.getName()+":"+s.getSalary()));
        }
        Map<String,Object> maps=EmployeeListener.salaryMap;
        if(!maps.isEmpty()){
           maps.forEach((k,v)-> System.out.println(k+":"+v));
        }

        String epl2="select name,age,children,address from "+Person.class.getName()+" where name like '%lue%'";
        statement =administrator.createEPL(epl2);
        statement.addListener(new UpdateListener() {
            public void update(EventBean[] newEvents, EventBean[] oldEvents) {
                for (EventBean newEvent : newEvents) {
                    System.out.println("name:"+newEvent.get("name")+",age:"+newEvent.get("age")+",children:"+newEvent.get("children")+
                            ",address:"+newEvent.get("address"));
                }
            }
        });
        for (int i=0;i<10;i++) {
            Person person = new Person();
            if(i==0) {
                person.setName("lueluelue");
            }else
            {
                person.setName("lueluelue"+i);
            }

            person.setAge(10+i);
            person.setSalary(1000+i*1000);
            person.setAddress(new Address("家"));
            Child child=new Child();
            child.setName("pipi");
            child.setAge(2);
            List<Child> children=new ArrayList<Child>();
            children.add(child);
            person.setChildren(children);
            runtime.sendEvent(person);
        }



    }
}
