package kr.co.ureca.sigw.controller;

import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import kr.co.ureca.sigw.repository.EmployeeRepository;
import kr.co.ureca.sigw.service.RequestVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/leave_requests")
public class RequestVacationController {
    @Autowired
    private RequestVacationService requestVacationService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String getVacationRequests(@RequestParam(required = false) Long empId, Model model) {
        if (empId != null) {
            Employee employee = employeeRepository.findById(empId)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            List<RequestVacation> leaveRequests = requestVacationService.getVacationRequests(empId);
            model.addAttribute("leaveRequests", leaveRequests);
            model.addAttribute("empName", employee.getEmpName());

            if ("Admin".equals(employee.getEmpRole())) {
                int departmentId = employee.getDepartment().getDepartmentId();
                List<RequestVacation> teamRequests = requestVacationService.getAllVacationRequestsByDepartmentExcludingEmployee(departmentId, empId);
                model.addAttribute("teamRequests", teamRequests);
            }

            model.addAttribute("empId", empId);
        }
        return "leave_requests";
    }

    @GetMapping("/form")
    public String showVacationRequestForm() {
        return "leave_request_form";
    }

    //Param말고 body 사용해보기
    @PostMapping("/form")
    public String submitLeaveRequest(@RequestParam("empId") Long empId,
                                     @RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("requestDate") String requestDate,
                                     @RequestParam("vacationType") String vacationType,
                                     @RequestParam("content") String content) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        requestVacationService.createLeaveRequest(empId,
                LocalDate.parse(startDate, formatter),
                LocalDate.parse(endDate, formatter),
                LocalDate.parse(requestDate, formatter),
                vacationType, content);
        return "redirect:/leave_requests";
    }

}