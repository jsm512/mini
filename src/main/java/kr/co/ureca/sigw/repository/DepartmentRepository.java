package kr.co.ureca.sigw.repository;

import kr.co.ureca.sigw.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

//메롱메롱