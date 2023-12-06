package com.example.litalab1employeeapplication.Controller;

import com.example.litalab1employeeapplication.entity.Employee;
import com.example.litalab1employeeapplication.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {
    private final EmployeeRepository repository;
    EmpController(EmployeeRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/employees/all")
    public String getAllEmployees(Model model) {

        try {
            List<Employee> employeeList = new ArrayList<Employee>();
            repository.findAll().forEach(employeeList::add);

            model.addAttribute("employeeList", employeeList);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "employeeList";
    }
}
