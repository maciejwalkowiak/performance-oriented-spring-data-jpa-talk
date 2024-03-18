package com.example;

import com.example.domain.BankTransfer;
import com.example.domain.BankTransferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenerateReportUseCase {
    private final BankTransferRepository bankTransferRepository;

    public GenerateReportUseCase(BankTransferRepository bankTransferRepository) {
        this.bankTransferRepository = bankTransferRepository;
    }

    @Transactional
    public void execute(String senderId) {
        List<BankTransfer> entries = bankTransferRepository.findBySenderId(senderId);

        for (BankTransfer sentTransfer : entries) {
            System.out.println(sentTransfer.getReceiver().getIban());
        }
    }
}
