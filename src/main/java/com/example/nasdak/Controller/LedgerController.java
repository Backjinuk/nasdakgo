package com.example.nasdak.Controller;

import com.example.nasdak.Domain.Category;
import com.example.nasdak.Domain.Ledger;
import com.example.nasdak.Domain.Users;
import com.example.nasdak.Dto.CategoryDto;
import com.example.nasdak.Dto.LedgerDto;
import com.example.nasdak.Dto.UsersDto;
import com.example.nasdak.Service.CategoryService;
import com.example.nasdak.Service.LedgerService;
import com.example.nasdak.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.reporters.jq.Model;

import java.util.Map;

@RestController
@RequestMapping("/api/ledger/")
public class LedgerController {

    @Autowired
    LedgerService ledgerService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("ledgerSave")
    public LedgerDto ledgerSave(@RequestBody Map<String, LedgerDto> requestData) {
        System.out.println("ledgerDto = " + requestData.get("LedgerDto"));
        LedgerDto ledgerDto= modelMapper.map(requestData.get("LedgerDto"), LedgerDto.class);

       ledgerDto.setUsers(userService.findById(ledgerDto.getUsersDto().getUserNo()));

       ledgerDto.setCategory(categoryService.findById(ledgerDto.getCategoryDto().getCategoryNo()));

        Ledger ledger = ledgerService.save(modelMapper.map(requestData.get("LedgerDto"), Ledger.class));
        return modelMapper.map(ledger, LedgerDto.class);
    }
}
