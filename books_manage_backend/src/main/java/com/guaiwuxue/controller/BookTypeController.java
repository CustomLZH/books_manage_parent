package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.constant.RolePermissionConstant;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.BookType;
import com.guaiwuxue.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeSet;

/**
 * @Author: Custom
 * @Date: 2020/7/17 20:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/bookType")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;


    /**
     * 根据分页信息进行分页查询
     * @param queryPageBean
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return bookTypeService.findPage(queryPageBean);
    }

    /**
     * 根据书籍类型id删除
     * @param typeId
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.BOOK_TYPE_DELETE + "')")
    @RequestMapping("/delete")
    public Result delete(String typeId){
        try{
            int count = bookTypeService.delete(typeId);
            if (count > 0){
                return new Result<>(false,MessageConstant.DELETE_BOOKTYPE_USE_FALL + count);
            }
            return new Result<>(true, MessageConstant.DELETE_BOOKTYPE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_BOOKTYPE_FAIL);
        }
    }

    /**
     * 创建书籍类型
     * @param bookType
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.BOOK_TYPE_CREATE + "')")
    @RequestMapping("/createBookType")
    public Result createBookType(@RequestBody BookType bookType){
        try {
            boolean bookType1 = bookTypeService.createBookType(bookType);
            if (!bookType1){
                return new Result<>(true,MessageConstant.UPDATE_BOOKTYPE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_BOOKTYPE_FAIL);
        }
        return new Result<>(true,MessageConstant.CREATE_BOOKTYPE_SUCCESS);
    }

    /**
     * 根据书籍类型id查询书籍类型名称
     * @param typeId
     * @return
     */
    @RequestMapping("/findBookTypeByTypeId")
    public Result<BookType> findBookTypeByTypeId(String typeId){
        BookType bookType = null;
        try {
            bookType = bookTypeService.findBookTypeByTypeId(typeId);
            if (bookType == null){
                return new Result<>(false,MessageConstant.QUERY_BOOKTYPE_NULL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.QUERY_BOOKTYPE_FAIL);
        }
        return new Result<>(true,MessageConstant.QUERY_BOOKTYPE_SUCCESS,bookType);
    }

    /**
     * 根据书籍类型更新
     * @param bookType
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.BOOK_TYPE_UPDATE + "')")
    @RequestMapping("/updateBookType")
    public Result updateBookType(@RequestBody BookType bookType){
        try {
            bookTypeService.updateBookType(bookType);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_BOOKTYPE_FAIL);
        }
        return new Result<>(true,MessageConstant.UPDATE_BOOKTYPE_SUCCESS);
    }

    /**
     * 查询所有书籍类型
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findBookTypeAll")
    public Result<TreeSet<BookType>> findBookTypeAll(){
        try {
            TreeSet<BookType> bookTypes = bookTypeService.findBookTypeAll();
            return new Result<>(true,MessageConstant.QUERY_BOOKTYPE_SUCCESS,bookTypes);
        }catch (Exception e){
            return new Result<>(false,MessageConstant.QUERY_BOOKTYPE_FAIL);
        }
    }

}
