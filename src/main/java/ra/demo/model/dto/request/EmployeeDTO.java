package ra.demo.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.demo.model.entity.Department;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO {
    @NotBlank(message = "Không được để trống họ tên nhân viên")
    private String fullName;
    @NotNull(message = "Không được để trống giới tính")
    private Boolean gender;
    @NotNull(message = "Không được để trống ngày sinh")
    private LocalDate birthday;
    @NotBlank(message = "Không được để trống địa chỉ")
    private String address;
    @NotNull(message = "Không được để trống phòng ban")
    private Department department;
}
