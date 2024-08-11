package kr.co.ureca.sigw.service;

import jakarta.persistence.EntityNotFoundException;
import kr.co.ureca.sigw.dto.RequestVacationDTO;
import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import kr.co.ureca.sigw.repository.EmployeeRepository;
import kr.co.ureca.sigw.repository.RequestVacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestVacationService {

    @Autowired
    private RequestVacationRepository requestVacationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<RequestVacation> getVacationRequests(Long empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        return requestVacationRepository.findByEmployee(employee);
    }

    public List<RequestVacation> getAllVacationRequestsByDepartmentExcludingEmployee(int departmentId, Long excludedEmpId) {
        return requestVacationRepository.findAllByDepartmentExcludingEmployee(departmentId, excludedEmpId);
    }

    public void createLeaveRequest(Long empId, LocalDate startDate, LocalDate endDate,
                                   LocalDate requestDate, String vacationType, String content) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + empId));

        RequestVacation requestVacation = new RequestVacation();
        requestVacation.setStartDate(startDate);
        requestVacation.setEndDate(endDate);
        requestVacation.setRequestDate(requestDate);
        requestVacation.setVacationType(vacationType);
        requestVacation.setContent(content);
        requestVacation.setEmployee(employee);
        requestVacation.setUpdateDate(LocalDate.now()); // 생성 시점에 업데이트 날짜 설정
        requestVacation.setRequestStatus("대기 중"); // 기본 상태 설정

        // DB에 저장
        requestVacationRepository.save(requestVacation);
    }
}
