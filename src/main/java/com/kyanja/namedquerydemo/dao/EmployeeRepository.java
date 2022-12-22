package com.kyanja.namedquerydemo.dao;

import com.kyanja.namedquerydemo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {
    List<Employee> findByName(String name);
    List<Employee> findByAge(int age);
    Employee findByEmail(String email);

    @Query(value = "SELECT e FROM Employee e ORDER BY name")
    List<Employee> findAllSortedByName();
}
