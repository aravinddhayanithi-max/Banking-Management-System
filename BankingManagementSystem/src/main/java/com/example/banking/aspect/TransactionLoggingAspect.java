package com.example.banking.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionLoggingAspect {

    @Before("execution(* com.example.banking.service.BankService.deposit(..))")
    public void beforeDeposit() {
        System.out.println("[BEFORE] Deposit operation started");
    }

    @Before("execution(* com.example.banking.service.BankService.withdraw(..))")
    public void beforeWithdraw() {
        System.out.println("[BEFORE] Withdrawal operation started");
    }

    @AfterReturning(
        pointcut = "execution(* com.example.banking.service.BankService.deposit(..))",
        returning = "result"
    )
    public void afterDeposit(Object result) {
        System.out.println("[AFTER RETURNING] Deposit successful. Updated balance: ₹" + result);
    }

    @AfterReturning(
        pointcut = "execution(* com.example.banking.service.BankService.withdraw(..))",
        returning = "result"
    )
    public void afterWithdraw(Object result) {
        System.out.println("[AFTER RETURNING] Withdrawal successful. Updated balance: ₹" + result);
    }

    @AfterThrowing(
        pointcut = "execution(* com.example.banking.service.BankService.*(..))",
        throwing = "exception"
    )
    public void afterThrowing(Throwable exception) {
        System.out.println("[AFTER THROWING] Transaction failed: " + exception.getMessage());
    }
}
