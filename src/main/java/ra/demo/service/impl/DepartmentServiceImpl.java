package ra.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.demo.model.dto.request.DepartmentDTO;
import ra.demo.model.entity.Department;
import ra.demo.repository.DepartmetRepository;
import ra.demo.service.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmetRepository departmetRepository;

    @Override
    public List<Department> getDepartments() {
        return departmetRepository.findAll();
    }

    @Override
    public Department insertDepartment(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .departId(departmentDTO.getDepartId())
                .departName(departmentDTO.getDepartName())
                .status(departmentDTO.getStatus())
                .build();
        return departmetRepository.save(department);
    }
}
