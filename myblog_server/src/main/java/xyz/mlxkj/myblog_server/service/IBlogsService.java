package xyz.mlxkj.myblog_server.service;

import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.model.Blogs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
public interface IBlogsService extends IService<Blogs> {

    result editBlog(Blogs blog);
}
