package com.syst.trades.service;

import com.syst.trades.dto.get.StatusResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private StatusRepository repository;

    public List<StatusResponse> getAllStatus() {
        return null;
//        return mapperHelper.mapToStatus(repository.findAll());
    }
}