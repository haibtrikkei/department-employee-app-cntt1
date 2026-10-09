package ra.demo.service;

import ra.demo.model.dto.request.DepartmentDTO;
import ra.demo.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();
    Department insertDepartment(DepartmentDTO departmentDTO);
}
