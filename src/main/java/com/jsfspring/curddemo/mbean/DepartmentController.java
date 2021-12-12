package com.jsfspring.curddemo.mbean;

import com.jsfspring.curddemo.service.DepartmentService;
import com.jsfspring.curddemo.service.EmployeeService;
import com.jsfspring.curddemo.uito.DepartmentUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mates on 2020. 11. 05..
 */
@Controller("deptController")
@SessionScope
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    public List<DepartmentUITO> getDepartmentUiToList() {
        return departmentUiToList;
    }

    public void setDepartmentUiToList(List<DepartmentUITO> departmentUiToList) {
        this.departmentUiToList = departmentUiToList;
    }

    private List<DepartmentUITO> departmentUiToList;


    @PostConstruct
    public void getAllDept() {
        departmentUiToList= new ArrayList<>();
        if (!this.getDepartmentUiToList().isEmpty()) {
            this.getDepartmentUiToList().clear();
        }
        this.getDepartmentUiToList().addAll(departmentService.getAllDepartment());
    }
}
