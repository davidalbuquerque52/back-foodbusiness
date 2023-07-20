package com.syst.trades.service;

import com.syst.trades.dto.get.PaymentModeResponse;
import com.syst.trades.dto.post.PaymentModeCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.PaymentMode;
import com.syst.trades.repository.PaymentModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentModeService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private PaymentModeRepository repository;

    public PaymentModeResponse getById(Long id) {
        return mapperHelper.mapToPaymentModeResponse(repository.findOne(id));
    }

    public List<PaymentModeResponse> getAllPaymentModes() {
        return mapperHelper.mapToPaymentModeResponseList(repository.findAll());
    }

    public PaymentModeResponse save(PaymentModeCreate paymentModeCreate) {
        PaymentMode paymentMode = mapperHelper.mapToPaymentMode(paymentModeCreate);
        paymentMode.setCreationDate(new Date());
        paymentMode.setUpdateDate(new Date());
        PaymentMode savedPaymentMode = repository.save(paymentMode);
        return mapperHelper.mapToPaymentModeResponse(savedPaymentMode);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}