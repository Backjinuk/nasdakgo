package com.example.nasdak.Service;

import com.example.nasdak.Domain.Ledger;
import com.example.nasdak.Dto.LedgerDto;
import com.example.nasdak.Repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerService {

    @Autowired
    LedgerRepository ledgerRepository;


    public Ledger save(Ledger ledger) { return ledgerRepository.save(ledger);
    }

    public int ledgerUpdate(Ledger ledger) { return ledgerRepository.ledgerUpdate(ledger.getFileManagerNo(), ledger.getDw(), ledger.getPrice(), ledger.getComment(), ledger.getLocation(), ledger.getCategory().getCategoryNo());
    }

    public void ledgerDelete(Ledger ledger) { ledgerRepository.deleteById(ledger.getFileManagerNo());
    }

    public List<Ledger> findAll() {
        return ledgerRepository.findAllByOrderByRegDateAsc();
    }

    public List<?> findAllByUsers(long userNo) {
        return ledgerRepository.findAllUsers(userNo);
    }

    public List<Ledger> ledgerItem(String regDate, long userNo) {
        return ledgerRepository.ledgerItem(regDate, userNo);
    }

    public Ledger ledgerDetail(Ledger ledger) {
        return ledgerRepository.getById(ledger.getFileManagerNo());
    }
}
