package com.kodilla.accounts.mapper;

import com.kodilla.accounts.domain.Account;
import com.kodilla.accounts.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AccountMapper {

    public Account toAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getNrb(), accountDto.getCurrency(),
                accountDto.getAvailableFunds(), accountDto.getCustomerId());
    }

    public AccountDto toAccountDto(Account account) {
        return new AccountDto(account.getId(), account.getNrb(), account.getCurrency(), account.getAvailableFunds(),
                account.getCustomerId());
    }

    public List<Account> toAccountList(List<AccountDto> accountDtos) {
        return accountDtos.stream()
                .map(this::toAccount)
                .collect(Collectors.toList());
    }

    public List<AccountDto> toAccountDtoList(List<Account> accounts) {
        return accounts.stream()
                .map(this::toAccountDto)
                .collect(Collectors.toList());
    }
}
