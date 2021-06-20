package com.pj.mybatisPlus.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pj.mybatisPlus.service.StudenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Studen)表控制层
 *
 * @author cdl
 * @since 2021-06-20 10:07:03
 */
@RestController
@RequestMapping("studen")
public class StudenController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StudenService studenService;


}