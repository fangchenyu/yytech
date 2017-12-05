package com.yytech.dao;

import com.yytech.dto.LogoDTO;
import com.yytech.dto.ProjectDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectDAO {
    //二级菜单查询
    List<LogoDTO> getAllChild(@Param("parentid") int parentid);

    //查找二级菜单下的所有图文
    List<ProjectDTO> getList(@Param("subtitleid") int subtitleid);
}
