# Web程序设计期末作业报告

[toc]

## 项目来源及背景

### 项目来源分析

#### 项目来源

随着互联网技术的发展和应用，作为一个程序员或者说软件开发的从业者，一个好的博客网站不仅仅是自己的技术实力的体现，写博客也是一种学习方法，可以加深自己的印象，互联网的核心就是分享，所以我选择来用本次所学知识写一个网站用来充当自己的博客，同时也可以分享给他人。

伴随着Web技术的发展，现在的Web开发已经不再是简单的HTML+CSS+JS的组合，而是一个完整的生态圈，前端框架层出不穷，后端语言也有很多选择，数据库也有很多种，所以我选择了一个比较流行的技术栈来实现这个项目。

前后端分离的开发模式，前端使用Vue.js框架，后端使用SpringBoot框架，数据库使用MySQL是当前比较流行的技术栈，这样可以更好的分工，提高开发效率。那么我这次也将立足于此技术栈来实现这个项目。

## 需求分析

本项目为一个博客网站，那么自然我需要一个博客网站的基本功能，包括：

- 用户注册登录
- 文章的增删改查
- 展示文章

## 数据库设计

## 系统总体设计

### 系统架构设计

#### 前端架构

前端使用Vue.js框架，使用Vue Router进行路由管理，使用Vuex进行状态管理，使用axios进行网络请求。我同时引入了ElementUI组件库，使用ElementUI的组件来构建页面。使用了`mavon-editor`这个Vue.js的Markdown编辑器组件来编辑和查看博客。

#### 后端架构

后端使用SpringBoot框架，使用MyBatis-plus进行数据库操作。Mysql作为数据库。

## 详细设计与实现

### 前端设计与实现

#### 用户模块

#### 博客模块

##### 博客详细信息模块

我们使用了现在比较流行的轻量化标记语言Markdown来书写博客，所以我们需要一个Markdown编辑器来编辑博客。在此我引入了 `mavon-editor`这个Vue.js的Markdown编辑器组件。利用这个组件进行修改文章的内容和查看文章的内容。

### 后端接口文档

#### 账户模块

- 登录接口

  - 请求方式：POST
  - 请求路径：/login
  - 请求参数：

    | 参数名   | 参数类型 | 是否必须 | 说明   |
    | -------- | -------- | -------- | ------ |
    | username | String   | 是       | 用户名 |
    | password | String   | 是       | 密码   |
  - 返回参数(校验成功)：

    ```json
    "data": {
    	"uid": 1,
    	"username": "liujitong",
    	"pwd": "1234",
    	"mail": "liumeili666@outlook.com",
    	"url": "https://www.mlxkj.xyz",
    	"screenName": "刘纪彤",
    	"group": "administrator"
    },
    "code": "200",
    "msg": "操作成功"
    ```

    - 返回参数(校验失败)：

    ```json
    {
    "data": null,
    "code": "-1",
    "msg": "用户名或密码错误"
    }
    ```

- 注册接口

  - 请求方式：POST
  - 请求路径：/register
  - 请求参数：

    | 参数名     | 参数类型 | 是否必须 | 说明   |
    | ---------- | -------- | -------- | ------ |
    | username   | String   | 是       | 用户名 |
    | password   | String   | 是       | 密码   |

  - 返回参数：

    ```json
    {
    "data": 1,
    "code": "200",
    "msg": "操作成功"
    }
    ```

    ```json
    {
      "data":null,
      "code":"-1",
      "msg":"用户名已存在"
    }
    ```

- 修改密码接口

  - 请求方式：POST
  - 请求路径：/changePwd
  - 请求参数：

    | 参数名     | 参数类型 | 是否必须 | 说明   |
    | ---------- | -------- | -------- | ------ |
    | username   | String   | 是       | 用户名 |
    | password   | String   | 是       | 密码   |

  - 返回参数：

    ```json
    {
    "data": 1,
    "code": "200",
    "msg": "操作成功"
    }
    ```

    ```json
    {
      "data":null,
      "code":"-1",
      "msg":"用户名不存在"
    }
    ```

#### 用户模块

- 获取用户信息

  - 请求方式：GET
  - 请求路径：/users/{uid}
  - 请求路径参数：

    | 参数名 | 参数类型 | 是否必须 | 说明   |
    | ------ | -------- | -------- | ------ |
    | uid    | Integer  | 是       | 用户ID |
  - 请求参数：无
  - 返回参数：

  ```json
  {
    "data": {
        "uid": 3,
        "username": "liujitong1",
        "pwd": "liujitong12",
        "mail": "sss@s.c",
        "url": "s.c",
        "screenName": "sdsd",
        "group": "visitor"
    },
    "code": "200",
    "msg": "操作成功"
  }
  ```
  
  ```json
  {
    "data": null,
    "code": "-1",
    "msg": "用户不存在"
  }
  ```

- 修改用户信息接口

  - 请求方式：POST
  - 请求路径：/users/edit
  - 请求参数：

    | 参数名      | 参数类型 | 是否必须 | 说明   |
    | ----------- | -------- | -------- | ------ |
    | uid         | Integer  | 是       | 用户ID |
    | username    | String   | 否       | 用户名 |
    | password    | String   | 否       | 密码   |
    | mail        | String   | 否       | 邮箱   |
    | url         | String   | 否       | 网址   |
    | screenName  | String   | 否       | 昵称   |
    | group       | String   | 否       | 用户组 |

  - 返回参数：

    ```json
    {
    "data": null,
    "code": "200",
    "msg": "操作成功"
    }
    ```

    ```json
    {
      "data":null,
      "code":"-1",
      "msg":"用户不存在"
    }
    ```

### 文章模块

- 编辑（新增）文章接口

  - 请求方式：POST
  - 请求路径：/blogs/edit
  - 请求参数：

    | 参数名  | 参数类型 | 是否必须 | 说明                       |
    | ------- | -------- | -------- | -------------------------- |
    | bid     | Integer  | 否       | 文章ID（缺省时为新增文章） |
    | title   | String   | 是       | 标题                       |
    | content | String   | 是       | 内容                       |
    | uid     | Integer  | 是       | 作者ID                     |
    | descp   | String   | 是       | 描述                       |
  - 返回参数：

    data为新增的文章的ID

    ```json
    {
      "data": null,
      "code": "-1",
      "msg": "博客不存在"
    }
    ```

    ```json
    {
      "data": null,
      "code": "200",
      "msg": "操作成功"
    }
    ```

    ```json
    {
      "data": 12,
      "code": "200",
      "msg": "数据库操作成功"
    } 
    ```

- 删除文章接口

  - 请求方式：GET
  - 请求路径：/blogs/delete/{bid}?uid={uid}

    - 请求路径参数:

  | 参数名 | 参数类型 | 是否必须 | 说明   |
  | ------ | -------- | -------- | ------ |
  | bid    | Integer  | 是       | 文章ID |
  | uid    | Integer  | 是       | 作者ID |

  - 请求参数：无
  - 返回参数：

    ```json
    {
        "data": null,
        "msg": "删除成功",
        "code": "200"
    }
    ```

    ```json
    {
      "data": null,
      "msg": "博客不存在",
      "code": "-1"
    }
    ```

  ```json
    {
        "data": null,
        "msg": "无权限删除",
        "code": "-1"
    }
    ```

- 获取文章列表接口

  - 请求方式：GET
  - 请求路径：/blogs/list?currentPage={currentPage}
  - 请求路径参数：

    | 参数名      | 参数类型 | 是否必须 | 说明     |
    | ----------- | -------- | -------- | -------- |
    | currentPage | Integer  | 是       | 当前页数 |

  - 返回参数：

    ```json
    {
    "data": {
      "records": [
        {
          "bid": 1,
          "uid": 1,
          "title": "测试测试",
          "descp": "测试文档",
          "content": "# 我的测试文档第一个\n第一个测试文档",
          "created": "2024-06-17 16:11"
        },
        {
          "bid": 6,
          "uid": 1,
          "title": "ssssssss",
          "descp": "ssssss",
          "content": "sssss",
          "created": "2024-06-17 13:38"
        },
        {
          "bid": 4,
          "uid": 1,
          "title": "ssssssss",
          "descp": "ssssss",
          "content": "sssss",
          "created": "2024-06-16 16:38"
        },
        {
          "bid": 5,
          "uid": 1,
          "title": "ssssssss",
          "descp": "ssssss",
          "content": "sssss",
          "created": "2024-06-16 16:38"
        }
      ],
      "total": 4,
      "size": 5,
      "current": 1,
      "pages": 1
    },
    "msg": "操作成功",
    "code": "200"
    }
    ```

    ```json
    {
      "data": {
        "records": [],
        "total": 4,
        "size": 5,
        "current": 2,
        "pages": 1
      },
      "msg": "操作成功",
      "code": "200"
    }
    ```

- 获取文章详细信息接口

  - 请求方式：GET
  - 请求路径：/blogs/{bid}
  - 请求路径参数：

    | 参数名 | 参数类型 | 是否必须 | 说明   |
    | ------ | -------- | -------- | ------ |
    | bid    | Integer  | 是       | 文章ID |

  - 请求参数：无
  - 返回参数：

    ```json
    {
    "data": {
      "bid": 1,
      "uid": 1,
      "title": "测试测试",
      "descp": "测试文档",
      "content": "# 我的测试文档第一个\n第一个测试文档",
      "created": "2024-06-17 16:11"
    },
    "msg": "操作成功",
    "code": "200"
    }
    ```

    ```json
    {
      "data": null,
      "msg": "博客不存在",
      "code": "-1"
    }
    ```

## 总结与体会

## 加分点

## 参考文献
