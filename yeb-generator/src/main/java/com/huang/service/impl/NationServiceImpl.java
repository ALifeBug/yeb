package com.huang.service.impl;

import com.huang.pojo.Nation;
import com.huang.mapper.NationMapper;
import com.huang.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-04
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
