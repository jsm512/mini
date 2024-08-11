package kr.co.ureca.sigw.service;

import jakarta.persistence.EntityNotFoundException;
import kr.co.ureca.sigw.dao.EmployeeDAO;
import kr.co.ureca.sigw.dao.RequestVacationDAO;
import kr.co.ureca.sigw.dto.RequestVacationDTO;
import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import kr.co.ureca.sigw.repository.EmployeeRepository;
import kr.co.ureca.sigw.repository.RequestVacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestVacationService {

    @Autowired
    private RequestVacationDAO requestVacationDAO;


    @Autowired
    private EmployeeDAO employeeDAO;
    public List<RequestVacationDTO> getRequestVacationsByEmployeeId(Long empId){
        Optional<Employee> employeeOpt =employeeDAO.findById(empId);

        if(employeeOpt.isEmpty()){
            return Collections.emptyList();
        }
        Employee employee = employeeOpt.get();
        List<RequestVacation> requestVacations = requestVacationDAO.finByEmployee(employee);

        return requestVacations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void createLeaveRequest(Long empId, LocalDateTime startDate, LocalDateTime endDate,
                                   LocalDateTime requestDate, String vacationType, String content) {
        // Employee 정보 조회
        Employee employee = employeeDAO.findById(empId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + empId));

        // RequestVacation 객체 생성
        RequestVacation requestVacation = new RequestVacation();
        requestVacation.setStartDate(startDate);
        requestVacation.setEndDate(endDate);
        requestVacation.setRequestDate(requestDate);
        requestVacation.setVacationType(vacationType);
        requestVacation.setContent(content);
        requestVacation.setEmployee(employee);
        requestVacation.setUpdateDate(LocalDateTime.now()); // 생성 시점에 업데이트 날짜 설정

        // DB에 저장
        requestVacationDAO.save(requestVacation);
    }
    private RequestVacationDTO convertToDTO(RequestVacation requestVacation) {
        RequestVacationDTO dto = new RequestVacationDTO();
        dto.setRequestId(requestVacation.getRequestId());
        dto.setStartDate(requestVacation.getStartDate());
        dto.setEndDate(requestVacation.getEndDate());
        dto.setVacationType(requestVacation.getVacationType());
        return dto;
    }
}