package xyz.mlxkj.myblog_server.service.impl;

import xyz.mlxkj.myblog_server.model.Blogs;
import xyz.mlxkj.myblog_server.dao.BlogsMapper;
import xyz.mlxkj.myblog_server.service.IBlogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@Service
public class BlogsServiceImpl extends ServiceImpl<BlogsMapper, Blogs> implements IBlogsService {

}
