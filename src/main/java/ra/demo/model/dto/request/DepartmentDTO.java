package ra.demo.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.demo.validator.DepartmentIdExist;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartmentDTO {
    @NotBlank(message = "Phải nhập mã phòng ban")
    @DepartmentIdExist
    private String departId;
    @NotBlank(message = "Phải nhập tên phòng ban")
    private String departName;
    @NotNull(message = "Phải nhập trạng thái phòng ban")
    private Boolean status;
}
