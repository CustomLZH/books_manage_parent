package com.guaiwuxue.service;

import com.guaiwuxue.entity.MonthFiveBorrowNumResp;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.WeekNumResp;
import com.guaiwuxue.pojo.BorrowInfo;

import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/1 14:54
 * @Version: 1.0
 */
public interface BorrowInfoService {

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    void delete(Long borrowInfoId);

    List<MonthFiveBorrowNumResp> monthFiveBorrowNum();

    void createBorrowInfo(BorrowInfo borrowInfo);

    void updateBorrowInfo(BorrowInfo borrowInfo);

    /**
     * 获取一周内每天的借阅量
     * @return
     */
    TreeSet<WeekNumResp> findWeekBorrowNum();
    /**
     * 获取一周内每天的归还量
     * @return
     */
    TreeSet<WeekNumResp> findWeekRestoreNum();
    /**
     * 获取一周内每天的挂失量
     * @return
     */
    TreeSet<WeekNumResp> findWeekLoseNum();
    /**
     * 获取一周内每天借阅用户量
     * @return
     */
    TreeSet<WeekNumResp> findWeekUsersNum();
}
