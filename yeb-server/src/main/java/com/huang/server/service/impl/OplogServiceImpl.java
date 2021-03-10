package com.huang.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.server.mapper.OplogMapper;
import com.huang.server.pojo.Oplog;
import com.huang.server.service.IOplogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Service
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
