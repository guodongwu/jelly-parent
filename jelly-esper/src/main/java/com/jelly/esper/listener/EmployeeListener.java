package com.jelly.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.jelly.esper.entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeListener implements UpdateListener {
    public final static List<Employee> employees=new ArrayList<Employee>();
    public final static Map<String,Object> salaryMap=new HashMap<>();
    public void update(EventBean[] eventBeans, EventBean[] eventBeans1) {
        for (EventBean eventBean:eventBeans){
            Employee employee=new Employee();
            String  name= (String) eventBean.get("name");
            employee.setName(name);
            Double salary= (Double) eventBean.get("salary");
            employee.setSalary(salary);
            Double salary_avg= (Double) eventBean.get("salary_avg");
            salaryMap.put(name,salary_avg);
            employees.add(employee);

        }
    }
}
