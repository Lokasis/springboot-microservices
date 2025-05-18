package net.loanmanagement.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentObjectResponse {
    private String message;
    private Student student;
}
