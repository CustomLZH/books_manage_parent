package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.service.BooksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 关于图书的调用
 * @Author: Custom
 * @Date: 2020/7/11 14:43
 * @Version: 1.0
 */
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    /**
     * 获取所有图书
     * @return
     */
    @RequestMapping("/findAll")
    public Result<List<Books>> findAll(){
        // 1. 调用service接口
        try {
            List<Books> booksList = booksService.findAll();
            return new Result<>(true,"获取成功",booksList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,"获取失败");
        }
    }
    /**
     * 获取所有图书部分信息
     * @return
     */
    @RequestMapping("/findAllToBorrowInfoCreate")
    public Result<List<Books>> findAllToBorrowInfoCreate(){
        // 1. 调用service接口
        try {
            List<Books> booksList = booksService.findAllToBorrowInfoCreate();
            return new Result<>(true,"获取成功",booksList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,"获取失败");
        }
    }



    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        //JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        return booksService.findPage(queryPageBean);
    }

    /**
     * 分页查询详细数据
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPageInfo")
    public PageResult findPageInfo(@RequestBody QueryPageBean queryPageBean){
        return booksService.findPageInfo(queryPageBean, "bookDate desc");
    }


    /**
     * 根据书籍id完成借阅功能库存更新
     * @param bookId
     * @param borrowNum
     * @return
     */
    @RequestMapping("/updateBorrowNumById")
    public Result<Void> updateBorrowNumById(@Param("bookId") int bookId, @Param("borrowNum") int borrowNum){
        try {
            booksService.updateBorrowNumById(bookId,borrowNum);
            return new Result<>(true,"借阅成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,"库存不足");
        }

    }

    /**
     * 根据书籍id查询书籍详细信息
     * @param bookId
     * @return
     */
    @RequestMapping("/findBookInfo")
    public Result<Books> findBookInfo(int bookId){
        try {
            Books bookInfo = booksService.findBookInfo(bookId);
            return new Result<>(true, MessageConstant.QUERY_BOOK_INFO_SUCCESS,bookInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.QUERY_BOOK_INFO_FAIL);
        }
    }

    /**
     * 根据数据进行书籍添加
     * @param books
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/insertBookByMap")
    public Result<Void> insertBookByMap(@RequestBody Books books) throws UnsupportedEncodingException {
        try {
            booksService.insertBook(books);
            return new Result<>(true,MessageConstant.CREATE_BOOK_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_BOOK_FAIL);
        }
    }

    /**
     * 根据书籍id删除书籍
     * @param bookId
     * @return
     */
    @RequestMapping("/deleteBookByBookId")
    public Result<Void> deleteBookByBookId(int bookId){
        try {
            booksService.deleteBookByBookId(bookId);
            return new Result<>(true,MessageConstant.DELETE_BOOK_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_BOOK_FAIL);
        }
    }

    /**
     * 根据书籍id更新书籍
     * @param books
     * @return
     */
    @RequestMapping("updateBookByBookId")
    public Result<Void> updateBookByBookId(@RequestBody Books books){
        try {
            booksService.updateBookByBookId(books);
            return new Result<>(true,MessageConstant.UPDATE_BOOK_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_BOOK_FAIL);
        }
    }


    /**
     * 根据书籍id更新书籍库存
     * @param books
     * @return
     */
    @RequestMapping("updateBookRepertoryByBookId")
    public Result updateBookRepertoryByBookId(@RequestBody Books books){
        try {
            booksService.updateBookRepertoryByBookId(books);
            return new Result(true,MessageConstant.UPDATE_BOOK_REPERTORY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.UPDATE_BOOK_REPERTORY_FAIL);
        }
    }

}
