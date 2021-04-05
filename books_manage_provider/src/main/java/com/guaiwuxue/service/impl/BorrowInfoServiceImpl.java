package com.guaiwuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.BorrowInfoDao;
import com.guaiwuxue.entity.MonthFiveBorrowNumResp;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.WeekNumResp;
import com.guaiwuxue.pojo.BorrowInfo;
import com.guaiwuxue.service.BorrowInfoService;
import com.guaiwuxue.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/1 14:55
 * @Version: 1.0
 */
@Service
public class BorrowInfoServiceImpl implements BorrowInfoService {

    @Autowired
    private BorrowInfoDao borrowInfoDao;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPageBean.getPageSize();
        //查询条件
        String requirement = queryPageBean.getRequirement();

        //保证页码正常
        if (currentPage == null || currentPage < 1){
            currentPage = 1;
        }
        //保证每页显示记录正常
        if (pageSize == null || pageSize < 1){
            pageSize = 10;
        }
        //保证条件正常
        if (requirement == null || "".equals(requirement.trim())){
            requirement = "";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }

        // 按typeId升序
//        String orderBy = "typeId asc";
        //初始化分页数据
        PageHelper.startPage(currentPage,pageSize);
        //调用查询，获得分页对象
        Page<BorrowInfo> page = borrowInfoDao.findPageByCondition("%" + requirement + "%");
        //返回分页结果数据
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void delete(Long borrowInfoId) {
        borrowInfoDao.delete(borrowInfoId);
    }

    @Override
    public List<MonthFiveBorrowNumResp> monthFiveBorrowNum() {
        return borrowInfoDao.monthFiveBorrowNum();
    }

    @Override
    public void createBorrowInfo(BorrowInfo borrowInfo) {
        borrowInfoDao.createBorrowInfo(borrowInfo);
    }

    @Override
    public void updateBorrowInfo(BorrowInfo borrowInfo) {
        borrowInfo.setUpdateDate(new Date());
        borrowInfoDao.updateBorrowInfo(borrowInfo);
    }

    @Override
    public TreeSet<WeekNumResp> findWeekBorrowNum() {
        TreeSet<WeekNumResp> weekBorrowNum = new TreeSet<>();
        List<Date> sevenDays = DateUtil.getSevenDays();
        int todayWeek = DateUtil.getTodayWeek();
        String[] weekNames = new String[] {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        for (Date sevenDay : sevenDays) {
            int week = DateUtil.getTodayWeek(sevenDay);
            String weekName = weekNames[week - 1];
            if (week > todayWeek) {
                weekName = "上" + weekName;
            }
            weekBorrowNum.add(new WeekNumResp(sevenDay, 0, week, weekName));
        }
        TreeSet<WeekNumResp> weekBorrowNum1 = borrowInfoDao.findWeekBorrowNum();
        weekBorrowNum.addAll(weekBorrowNum1);
        return weekBorrowNum;
    }
}
