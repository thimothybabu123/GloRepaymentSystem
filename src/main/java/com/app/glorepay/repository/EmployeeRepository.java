package com.app.glorepay.repository;

import com.app.glorepay.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// make this into a employee repository
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    public Employee findByemployeeId(Long employeeId);
}
