package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.entity.MonthFiveBorrowNumResp;
import com.guaiwuxue.entity.WeekNumResp;
import com.guaiwuxue.pojo.BorrowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/1 14:58
 * @Version: 1.0
 */
public interface BorrowInfoDao {

    /**
     * 分页查询，可带条件
     * @param requirement
     * @return
     */
    public Page<BorrowInfo> findPageByCondition(@Param("requirement") String requirement);

    /**
     * 删除借阅信息
     * @param borrowInfoId
     */
    void delete(Long borrowInfoId);

    /**
     * 月度前五借阅量
     * @return
     */
    List<MonthFiveBorrowNumResp> monthFiveBorrowNum();

    /**
     * 添加借阅信息
     * @param borrowInfo
     */
    void createBorrowInfo(BorrowInfo borrowInfo);

    /**
     * 更新借阅信息
     * @param borrowInfo
     */
    void updateBorrowInfo(BorrowInfo borrowInfo);

    /**
     * 获取一周内每天的借阅量
     */
    TreeSet<WeekNumResp> findWeekBorrowNum(Date start, Date end);
}
