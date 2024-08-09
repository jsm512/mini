package kr.co.ureca.sigw.dao;

import kr.co.ureca.sigw.entity.Employee;
import kr.co.ureca.sigw.entity.RequestVacation;
import kr.co.ureca.sigw.repository.RequestVacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestVacationDAO {

    @Autowired
    private RequestVacationRepository requestVacationRepository;

    public List<RequestVacation> finByEmployee(Employee employee){
        return requestVacationRepository.findByEmployee(employee);
    }

    public void save(RequestVacation requestVacation){
        requestVacationRepository.save(requestVacation);
    }
}
