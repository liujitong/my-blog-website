package xyz.mlxkj.myblog_server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.dao.UsersMapper;
import xyz.mlxkj.myblog_server.model.Blogs;
import xyz.mlxkj.myblog_server.dao.BlogsMapper;
import xyz.mlxkj.myblog_server.model.Users;
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
    @Autowired
    private BlogsMapper blogsMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public result editBlog(Blogs blog) {
        if (blog.getBid() == null) {
            Blogs newBlog=new Blogs();
            newBlog.setTitle(blog.getTitle());
            newBlog.setContent(blog.getContent());
            newBlog.setDescp(blog.getDescp());
            newBlog.setUid(blog.getUid());
            newBlog.setCreated(blog.getCreated());
            System.out.println(newBlog);
            blogsMapper.insert(newBlog);
            // 获取插入数据的主键 ID
            Long id = newBlog.getBid();
            System.out.println("插入数据的主键 ID：" + id);
            if(id!=null) {
                return result.succ("数据库操作成功",id);
            }
            else {
                return result.fail("数据库操作失败");
            }
        }
        else {
            //查询bid的内容
            Blogs oldBlog = blogsMapper.selectById(blog.getBid());
            Users user = usersMapper.selectById(blog.getUid());
            //查询bid的uid和传入的uid是否一致
            if(oldBlog.getUid().equals(blog.getUid())){
                blogsMapper.updateById(blog);
                return result.succ("数据库操作成功");
            }
            else {
                if(usersMapper.selectById(blog.getUid()).getGroup().equals("administrator")){
                    blogsMapper.updateById(blog);
                    return result.succ("数据库操作成功");
                }
                return result.fail("无权限修改");
            }
        }

    }
}
