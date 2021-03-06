package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.constant.RolePermissionConstant;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.BorrowInfo;
import com.guaiwuxue.service.BorrowInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/1 14:51
 * @Version: 1.0
 */
@RestController
@RequestMapping("/borrowInfo")
public class BorrowInfoController {

    @Autowired
    private BorrowInfoService borrowInfoService;

    /**
     * 分页查询
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return borrowInfoService.findPage(queryPageBean);
    }

    /**
     * 根据借阅id删除
     * @param borrowInfoId
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.DELETE_BORROW_INFO + "')")
    @RequestMapping("/delete")
    public Result<Void> delete(Long borrowInfoId){
        try{
            borrowInfoService.delete(borrowInfoId);
            return new Result<>(true, MessageConstant.DELETE_BORROW_INFO_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_BORROW_INFO_FAIL);
        }
    }

    /**
     * 添加借阅信息
     * @param borrowInfo
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.CREATE_BORROW_INFO + "')")
    @RequestMapping("/createBorrowInfo")
    public Result<Void> createBorrowInfo(@RequestBody BorrowInfo borrowInfo) {
        if (borrowInfo == null || borrowInfo.getBookId() == null || borrowInfo.getUserId() == null ||
            borrowInfo.getBorrowDate() == null || borrowInfo.getReturnDate() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            borrowInfoService.createBorrowInfo(borrowInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_BORROW_INFO_FAIL);
        }
        return new Result<>(true,MessageConstant.CREATE_BORROW_INFO_SUCCESS);
    }

    /**
     * 更新借阅信息
     * @param borrowInfo
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.UPDATE_BORROW_INFO + "')")
    @RequestMapping("/updateBorrowInfo")
    public Result<Void> updateBorrowInfo(@RequestBody BorrowInfo borrowInfo) {
        if (borrowInfo == null || borrowInfo.getBookId() == null || borrowInfo.getUserId() == null ||
            borrowInfo.getBorrowDate() == null || borrowInfo.getReturnDate() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            borrowInfoService.updateBorrowInfo(borrowInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_BORROW_INFO_FAIL);
        }
        return new Result<>(true,MessageConstant.UPDATE_BORROW_INFO_SUCCESS);
    }


    /**
     * 根据借阅集合删除
     * @param multipleSelection
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.DELETE_BORROW_INFO + "')")
    @RequestMapping("/deleteAll")
    public Result<Void> deleteAll(@RequestBody List<BorrowInfo> multipleSelection){
        try{
            borrowInfoService.deleteAll(multipleSelection);
            return new Result<>(true, MessageConstant.DELETE_BORROW_INFO_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_BORROW_INFO_FAIL);
        }
    }

}
