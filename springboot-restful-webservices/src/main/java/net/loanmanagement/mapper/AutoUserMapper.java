package net.loanmanagement.mapper;

import net.loanmanagement.dto.CreateLoanRequest;
import net.loanmanagement.dto.LoanDto;
import net.loanmanagement.dto.UserActionDto;
import net.loanmanagement.dto.UserDto;
import net.loanmanagement.model.Loan;
import net.loanmanagement.model.User;
import net.loanmanagement.model.UserAction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

    UserAction mapToUserAction(UserActionDto userActionDto);

    UserActionDto mapToUserActionDto(UserAction userAction);

    Loan toLoan(CreateLoanRequest request);

    LoanDto toLoanDto(Loan loan);
}
