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

    @PostMapping("/form")
    public String submitVacationRequest(
            @RequestParam Long empId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate,
            @RequestParam String requestStatus,
            @RequestParam String content){

        requestVacationService.createVacationRequest(empId, startDate, endDate, requestStatus, content);
        return "redirect:/leave_request_form";
    }

}