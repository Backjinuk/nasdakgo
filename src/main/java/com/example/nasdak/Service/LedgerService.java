package com.example.nasdak.Service;

import com.example.nasdak.Domain.Ledger;
import com.example.nasdak.Repository.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedgerService {

    @Autowired
    LedgerRepository ledgerRepository;


    public void save(Ledger ledger) { ledgerRepository.save(ledger);
    }

    public void ledgerUpdate(Ledger ledger) { ledgerRepository.ledgerUpdate(ledger.getFileManagerNo(), ledger.getDw(), ledger.getPrice(), ledger.getComment(), ledger.getLocation());
    }

    public void ledgerDelete(Ledger ledger) { ledgerRepository.deleteById(ledger.getFileManagerNo());
    }

    public List<Ledger> findAll() {
        return ledgerRepository.findAll();
    }
}
