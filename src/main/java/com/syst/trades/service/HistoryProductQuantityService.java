package com.syst.trades.service;

import com.syst.trades.dto.get.HistoryProductQuantityResponse;
import com.syst.trades.dto.post.HistoryProductQuantityCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.HistoryProductQuantity;
import com.syst.trades.repository.HistoryProductQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryProductQuantityService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private HistoryProductQuantityRepository repository;

    public HistoryProductQuantityResponse getById(Long id) {
        return mapperHelper.mapToHistoryProductQuantityResponse(repository.findOne(id));
    }

    public List<HistoryProductQuantityResponse> getAllHistoryProductQuantities() {
        return mapperHelper.mapToHistoryProductQuantityResponseList(repository.findAll());
    }

    public HistoryProductQuantityResponse save(HistoryProductQuantityCreate historyProductQuantityCreate) {
        HistoryProductQuantity historyProductQuantity = mapperHelper.mapToHistoryProductQuantity(historyProductQuantityCreate);
        historyProductQuantity.setCreationDate(new Date());
        historyProductQuantity.setUpdateDate(new Date());
        HistoryProductQuantity savedHistoryProductQuantity = repository.save(historyProductQuantity);
        return mapperHelper.mapToHistoryProductQuantityResponse(savedHistoryProductQuantity);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}