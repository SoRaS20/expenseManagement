package com.example.expenseManager.service;

import com.example.expenseManager.dto.requestDto.ExpenseRequestDto;
import com.example.expenseManager.entity.ExpenseEntity;
import com.example.expenseManager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {
//    @Autowired
//    private final ExpenseRepository expenseRepository;

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public String createExpense(ExpenseRequestDto requestDto){
        if(requestDto != null){
            ExpenseEntity expense = new ExpenseEntity();
            expense.setExpenseCategory(requestDto.getExpenseCategory());
            expense.setExpenseName(requestDto.getExpenseName());
            expense.setDescription(requestDto.getDescription());
            expense.setDate(requestDto.getDate());
            expense.setAmount(requestDto.getAmount());

            expenseRepository.save(expense);
            return "Expense Created";
        }

        else return "Unable to create Expense Entity";
    }

    public List<ExpenseEntity>getAllExpense(){
        return expenseRepository.findAll();

    }
}
