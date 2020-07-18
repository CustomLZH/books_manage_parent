package com.guaiwuxue.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.service.BooksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关于图书的调用
 * @Author: Custom
 * @Date: 2020/7/11 14:43
 * @Version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BooksController {

    @Reference
    private BooksService booksService;

    /**
     * 获取所有图书
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(){
        // 1. 调用service接口
        try {
            List<Books> booksList = booksService.findAll();
            return new Result(true,"获取成功",booksList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"获取失败");
        }
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return booksService.findPage(queryPageBean);
    }


    @RequestMapping("/updateBorrowNumById")
    public Result updateBorrowNumById(@Param("bookId") int bookId, @Param("borrowNum") int borrowNum){

        try {
            booksService.updateBorrowNumById(bookId,borrowNum);
            return new Result(true,"借阅成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"库存不足");
        }

    }

}
