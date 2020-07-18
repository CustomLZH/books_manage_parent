package com.guaiwuxue.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.BookType;
import com.guaiwuxue.service.BookTypeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Custom
 * @Date: 2020/7/17 20:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/bookType")
public class BookTypeController {

    @Reference
    private BookTypeService bookTypeService;


    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return bookTypeService.findPage(queryPageBean);
    }

    @RequestMapping("/delete")
    public Result delete(String typeId){
        try{
            int count = bookTypeService.delete(typeId);
            if (count > 0){
                return new Result(false,MessageConstant.DELETE_BOOKTYPE_USE_FALL + count);
            }
            return new Result(true, MessageConstant.DELETE_BOOKTYPE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_BOOKTYPE_FAIL);
        }
    }

    @RequestMapping("/createBookType")
    public Result createBookType(@RequestBody BookType bookType){
        try {
            boolean bookType1 = bookTypeService.createBookType(bookType);
            if (!bookType1){
                return new Result(true,MessageConstant.UPDATE_BOOKTYPE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.CREATE_BOOKTYPE_FAIL);
        }
        return new Result(true,MessageConstant.CREATE_BOOKTYPE_SUCCESS);
    }

    @RequestMapping("/findBookTypeByTypeId")
    public Result findBookTypeByTypeId(String typeId){
        BookType bookType = null;
        try {
            bookType = bookTypeService.findBookTypeByTypeId(typeId);
            if (bookType == null){
                return new Result(false,MessageConstant.QUERY_BOOKTYPE_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_BOOKTYPE_FAIL);
        }
        return new Result(true,MessageConstant.QUERY_BOOKTYPE_SUCCESS,bookType);
    }

    @RequestMapping("/updateBookType")
    public Result updateBookType(@RequestBody BookType bookType){
        try {
            bookTypeService.updateBookType(bookType);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.UPDATE_BOOKTYPE_FAIL);
        }
        return new Result(true,MessageConstant.UPDATE_BOOKTYPE_SUCCESS);
    }

}
