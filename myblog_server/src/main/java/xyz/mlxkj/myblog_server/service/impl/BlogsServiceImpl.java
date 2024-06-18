package xyz.mlxkj.myblog_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public result getBlogList(Integer currentPage) {
        //根据currentPage为页数，以created倒序排列
        Page page = new Page(currentPage, 5);
        IPage<Blogs> pageData = blogsMapper.selectPage(page,  new QueryWrapper<Blogs>().orderByDesc("created"));
        return result.succ(pageData);
    }

    @Override
    public result deleteBlog(Integer bid, Long uid) {
        //如果uid是管理员或者uid和bid的uid一致
        System.out.println("uid"+uid);
        System.out.println("bid"+bid);
        Blogs blog = blogsMapper.selectById(bid);
        Users user = usersMapper.selectById(uid);
        if(blog.getUid()==uid||user.getGroup().equals("administrator")){
            blogsMapper.deleteById(bid);
            return result.succ("删除成功");
        }
        else {
            return result.fail("无权限删除");
        }
    }
}
