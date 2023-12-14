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
import org.apache.ibatis.annotations.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testng.reporters.jq.Model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @RequestMapping("LedgerList")
    public List<?> LedgerList(@RequestBody UsersDto usersDto){

        return ledgerService.findAllByUsers(usersDto.getUserNo());
//                .stream().map(ledger -> {
//                    LedgerDto ledgerDto = modelMapper.map(ledger, LedgerDto.class);
//
//                    //Entity를 Dto로 변환
//                    ledgerDto.setUsersDto(modelMapper.map(ledger.getUsers(), UsersDto.class));
//                    ledgerDto.setCategoryDto(modelMapper.map(ledger.getCategory(), CategoryDto.class));
//
//                    //Entity 초기화
//                    ledgerDto.setUsers(null); ledgerDto.setCategoryDto(null);
//
//                    return ledgerDto;
//                })
//                .collect(Collectors.toList());
    }

    @RequestMapping("ledgerItem")
    public List<LedgerDto> ledgerItem(@RequestBody LedgerDto ledgerDto) {

        System.out.println("userNo.get() = " + ledgerDto.getUserNo());
        System.out.println("reg_date.get() = " + ledgerDto.getRegDate2());

        return ledgerService.ledgerItem( ledgerDto.getRegDate2(), ledgerDto.getUserNo())
                .stream().map(ledger -> {
                    LedgerDto ledgerDto2 = modelMapper.map(ledger, LedgerDto.class);

                    //Entity를 Dto로 변환
                    ledgerDto2.setUsersDto(modelMapper.map(ledger.getUsers(), UsersDto.class));
                    ledgerDto2.setCategoryDto(modelMapper.map(ledger.getCategory(), CategoryDto.class));

                    //Entity 초기화
                    ledgerDto2.setUsers(null); ledgerDto2.setCategoryDto(null);

                    return ledgerDto2;
                })
                .collect(Collectors.toList());
    }

    @RequestMapping("ledgertDetail")
    public LedgerDto ledgerDetail(@RequestBody LedgerDto ledgerDto){
        Ledger ledger = ledgerService.ledgerDetail(modelMapper.map(ledgerDto, Ledger.class));

        ledgerDto = modelMapper.map(ledger, LedgerDto.class);

        ledgerDto.setCategoryDto(modelMapper.map(ledgerDto.getCategory(), CategoryDto.class));
        ledgerDto.setUsersDto(modelMapper.map(ledgerDto.getUsers(), UsersDto.class));
        ledgerDto.setCategory(null); ledgerDto.setUsers(null);

        return ledgerDto;
    }

    @RequestMapping("ledgerItemUpdate")
    public Map<String, Objects> ledgerItemUpdate(@RequestBody LedgerDto ledgerDto){

        return null;
    }
}
