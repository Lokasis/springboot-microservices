package net.loanmanagement.mapper;

import net.loanmanagement.dto.*;
import net.loanmanagement.model.Loan;
import net.loanmanagement.model.User;
import net.loanmanagement.model.UserAction;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

    UserAction mapToUserAction(UserActionDto userActionDto);

    UserActionDto mapToUserActionDto(UserAction userAction);

    Loan toLoan(CreateLoanRequest request);

    LoanDto toLoanDto(Loan loan);

    @Mapping(target = "borrowerName", ignore = true)
    Loan updateRequestToLoan(UpdateLoanRequest request, @MappingTarget Loan loan);
}
