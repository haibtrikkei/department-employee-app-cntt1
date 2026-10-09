package ra.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.request.EmployeeDTO;
import ra.demo.model.dto.response.ApiDataResponse;
import ra.demo.model.entity.Employee;
import ra.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @Value("${page_employee_size}")
    private Integer pageSize;

    @GetMapping
    public ResponseEntity<ApiDataResponse<Page<Employee>>> getEmployee(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách nhân viên trang " + page + " thành công",
                employeeService.getEmployees(page - 1, pageSize),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/employees-sorting")
    public ResponseEntity<ApiDataResponse<Page<Employee>>> getEmployeeSorting(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                                                              @RequestParam(name = "sortBy", defaultValue = "empId") String sortBy,
                                                                              @RequestParam(name = "orderBy", defaultValue = "asc") String orderBy) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách nhân viên trang " + page + " thành công",
                employeeService.getEmployeesWithSorting(page - 1, pageSize, sortBy, orderBy),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> insertEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới nhân viên thành công",
                employeeService.insertEmployee(employeeDTO),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<ApiDataResponse<Employee>> getEmployeeById(@PathVariable Long empId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy thông tin nhân viên " + empId + " thành công",
                employeeService.getEmployeeById(empId),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
