package com.example.nasdak.Domain;

import com.example.nasdak.Dto.CategoryDto;
import com.example.nasdak.Dto.LedgerDto;
import com.example.nasdak.Dto.UsersDto;
import com.example.nasdak.Service.CategoryService;
import com.example.nasdak.Service.LedgerService;
import com.example.nasdak.Service.UserService;
import com.example.nasdak.Utils.DataUtils;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.xml.crypto.Data;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LedgerTest {

    @Autowired
    LedgerService ledgerService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @Test
    public void ledgerSave(){
        LedgerDto ledgerDto = new LedgerDto();
        Users users = userService.findById(1L);
        Category category = categoryService.findById(3L);

        ledgerDto.setUsers(users);
        ledgerDto.setCategory(category);
        ledgerDto.setDw(1000L);
        ledgerDto.setPrice(30000L);
        ledgerDto.setLocation("창원시 진해구 소사동");
        ledgerDto.setComment("너무 과소비 했다....");
        ledgerDto.setRegDate(DataUtils.parseDateTime(DataUtils.getCurrentDateTimeAsString()));

        ledgerService.save(modelMapper.map(ledgerDto, Ledger.class));
    }

    @Test
    public void ledgerUpdate(){
        LedgerDto ledgerDto = new LedgerDto();

        ledgerDto.setFileManagerNo(10L);
        ledgerDto.setComment("수정한  글입니다.");
        ledgerDto.setDw(300000l);
        ledgerDto.setPrice(300000000l);
        ledgerDto.setLocation("서울시 강남구 논현동");
        
        ledgerService.ledgerUpdate(modelMapper.map(ledgerDto, Ledger.class));
    }

    @Test
    public void ledgerDelete(){
        LedgerDto ledgerDto = new LedgerDto();
        ledgerDto.setFileManagerNo(11l);
        ledgerService.ledgerDelete(modelMapper.map(ledgerDto, Ledger.class));
    }
    
    @Test
    public void ledgerList(){
        List<LedgerDto> ledgerDtoList = ledgerService.findAll().stream().map(ledger -> modelMapper.map(ledger, LedgerDto.class)).collect(Collectors.toList());

        for (LedgerDto ledgerDto : ledgerDtoList) {
            System.out.println("ledgerDto = " + ledgerDto);
        }
    }





}