package kr.co.ureca.sigw.dao;

import jakarta.persistence.EntityNotFoundException;
import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDAO {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findById(Long empId){
        return employeeRepository.findById(empId);
    }
}
