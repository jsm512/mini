package kr.co.ureca.sigw.repository;

import kr.co.ureca.sigw.entity.Department;
import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestVacationRepository extends JpaRepository<RequestVacation, Long> {
    List<RequestVacation> findByEmployee(Employee employee);

    @Query("SELECT rv FROM RequestVacation rv WHERE rv.employee.department.departmentId = :departmentId AND rv.employee.empId <> :excludedEmpId")
    List<RequestVacation> findAllByDepartmentExcludingEmployee(@Param("departmentId") int departmentId, @Param("excludedEmpId") Long excludedEmpId);

}
