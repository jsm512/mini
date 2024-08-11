package kr.co.ureca.sigw.controller;

import kr.co.ureca.sigw.dao.EmployeeDAO;
import kr.co.ureca.sigw.dto.RequestVacationDTO;
import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.service.RequestVacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/leave_requests")
public class RequestVacationController {
    @Autowired
    private RequestVacationService requestVacationService;

    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping
    public ModelAndView getVacationRequests(@RequestParam(required = false) Long empId) {
        ModelAndView mav = new ModelAndView("leave_requests");
        if(empId != null) {
            String empName = employeeDAO.findById(empId)
                    .map(Employee::getEmpName)
                    .orElse("누구쇼");
            List<RequestVacationDTO> leaveRequests = requestVacationService.getRequestVacationsByEmployeeId(empId);
            mav.addObject("leaveRequests", leaveRequests);
            mav.addObject("empId", empId);
            mav.addObject("empName", empName);
        }
        return mav;
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        requestVacationService.createLeaveRequest(empId,
                LocalDateTime.parse(startDate, formatter),
                LocalDateTime.parse(endDate, formatter),
                LocalDateTime.parse(requestDate, formatter),
                vacationType, content);
        return "redirect:/leave_requests";
    }

}