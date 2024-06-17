package xyz.mlxkj.myblog_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.mlxkj.myblog_server.common.result;
import xyz.mlxkj.myblog_server.model.Blogs;
import xyz.mlxkj.myblog_server.service.IBlogsService;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘纪彤
 * @since 2024-06-16
 */
@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private IBlogsService blogsService;

    @RequestMapping("/edit")
    public result editBlog(@RequestBody @Validated Blogs blog){
        System.out.println(blog);
        blog.setCreated(LocalDateTime.now());
        return blogsService.editBlog(blog);
    }
    @GetMapping("{bid}")
    public result getBlogDetail (@PathVariable(name="bid") Integer bid){
        System.out.println("bid"+bid);
        Blogs blog = blogsService.getById(bid);
        if(blog!=null){
            return result.succ(blog);
        }
        else {
            return result.fail("博客不存在");
        }
    }


}
