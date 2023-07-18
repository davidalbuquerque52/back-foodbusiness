package com.syst.trades.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class MapperHelper {

    @Autowired
    private ModelMapper modelMapper;

}