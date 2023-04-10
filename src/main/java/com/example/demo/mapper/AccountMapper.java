package com.example.demo.mapper;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",imports = UserMapper.class)
public interface AccountMapper {
    @Mapping(target = "user", ignore = true)
    Account accountDtoToAccount(AccountDTO accountDTO);
    @Mapping(target = "user", ignore = true)
    AccountDTO accountToAccountDto(Account account);
}
