package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.entity.MonthFiveBorrowNumResp;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.entity.WeekAllNumResp;
import com.guaiwuxue.entity.WeekNumResp;
import com.guaiwuxue.service.BorrowInfoService;
import com.guaiwuxue.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/4 15:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private BorrowInfoService borrowInfoService;
    @Autowired
    private HomeService homeService;

    /**
     * 获取月季度前五借阅量
     * @return
     */
    @RequestMapping("/monthFiveBorrowNum")
    public Result<List<MonthFiveBorrowNumResp>> monthFiveBorrowNum() {
        List<MonthFiveBorrowNumResp> monthFiveBorrowNumResps = null;
        try {
            monthFiveBorrowNumResps = borrowInfoService.monthFiveBorrowNum();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, MessageConstant.QUERY_MONTH_FIVE_BORROW_NUM_FAIL);
        }
        return new Result<>(true, MessageConstant.QUERY_MONTH_FIVE_BORROW_NUM_SUCCESS, monthFiveBorrowNumResps);
    }

    /**
     * 获取一周内每天的借阅量
     * @return
     */
    @RequestMapping("/findWeekBorrowNum")
    public Result<TreeSet<WeekNumResp>> findWeekBorrowNum() {
        TreeSet<WeekNumResp> weekBorrowNum = null;
        try {
            weekBorrowNum = borrowInfoService.findWeekBorrowNum();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, MessageConstant.QUERY_WEEK_BORROW_NUM_FAIL);
        }
        return new Result<>(true,MessageConstant.QUERY_WEEK_BORROW_NUM_SUCCESS, weekBorrowNum);
    }
    /**
     * 获取一周内每天的所有信息
     * @return
     */
    @RequestMapping("/findWeekAllNum")
    public Result<List<WeekAllNumResp>> findWeekAllNum() {
        List<WeekAllNumResp> weekAllNums = null;
        try {
            weekAllNums = homeService.findWeekAllNum();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, MessageConstant.QUERY_WEEK_ALL_NUM_FAIL);
        }
        return new Result<>(true,MessageConstant.QUERY_WEEK_ALL_NUM_SUCCESS, weekAllNums);
    }


}
