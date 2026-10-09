package ra.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import ra.demo.repository.DepartmetRepository;
@RequiredArgsConstructor
public class DepartmentIdExistValidator implements ConstraintValidator<DepartmentIdExist,String> {
    private final DepartmetRepository departmetRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null || value.isEmpty()){
            return true;
        }

        if(departmetRepository.findById(value).orElse(null)==null){
            return true;
        }
        return false;
    }
}
