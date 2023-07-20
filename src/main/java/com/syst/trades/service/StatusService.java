package com.syst.trades.service;

import com.syst.trades.dto.get.StatusResponse;
import com.syst.trades.dto.post.StatusCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Status;
import com.syst.trades.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private StatusRepository repository;

    public StatusResponse getById(Integer id) {
        return mapperHelper.mapToStatusResponse(repository.findOne(id));
    }

    public List<StatusResponse> getAllStatus() {
        return mapperHelper.mapToStatusResponseList(repository.findAll());
    }

    public StatusResponse save(StatusCreate statusCreate) {
        Status status = mapperHelper.mapToStatus(statusCreate);
        status.setCreationDate(new Date());
        status.setUpdateDate(new Date());
        Status savedStatus = repository.save(status);
        return mapperHelper.mapToStatusResponse(savedStatus);
    }

    public void removeById(Integer id) {
        repository.delete(id);
    }
}