package com.yytech.dao;

import com.yytech.dto.ServiceDTO;

import java.util.List;

public interface ServiceDAO {
    //查询所有服务
    List<ServiceDTO> getAllService();
}
