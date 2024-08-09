package kr.co.ureca.sigw.repository;

import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestVacationRepository extends JpaRepository<RequestVacation, Long> {
    List<RequestVacation> findByEmployee(Employee employee);
}
