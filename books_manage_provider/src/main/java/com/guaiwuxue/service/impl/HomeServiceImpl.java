package com.guaiwuxue.service.impl;

import com.guaiwuxue.entity.WeekAllNumResp;
import com.guaiwuxue.entity.WeekNumResp;
import com.guaiwuxue.service.BorrowInfoService;
import com.guaiwuxue.service.HomeService;
import com.guaiwuxue.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/4 15:46
 * @Version: 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private BorrowInfoService borrowInfoService;

    @Override
    public List<WeekAllNumResp> findWeekAllNum() {
        List<WeekAllNumResp> weekAllNums = new ArrayList<>();
        // 添加借阅信息
        WeekAllNumResp weekBorrowNumResp = new WeekAllNumResp();
        weekBorrowNumResp.setName("借阅");
        weekBorrowNumResp.setType("line");
        weekBorrowNumResp.setStack("借阅");
        weekBorrowNumResp.setData(borrowInfoService.findWeekBorrowNum());
        weekAllNums.add(weekBorrowNumResp);


        // 添加归还信息
        WeekAllNumResp weekRestoreNumResp = new WeekAllNumResp();
        weekRestoreNumResp.setName("归还");
        weekRestoreNumResp.setType("line");
        weekBorrowNumResp.setStack("归还");
        weekRestoreNumResp.setData(borrowInfoService.findWeekRestoreNum());
        weekAllNums.add(weekRestoreNumResp);


        // 添加挂失信息
        WeekAllNumResp weekLoseNumResp = new WeekAllNumResp();
        weekLoseNumResp.setName("挂失");
        weekLoseNumResp.setType("line");
        weekBorrowNumResp.setStack("挂失");
        weekLoseNumResp.setData(borrowInfoService.findWeekLoseNum());
        weekAllNums.add(weekLoseNumResp);

        // 添加用户信息
        WeekAllNumResp weekUserNumResp = new WeekAllNumResp();
        weekUserNumResp.setName("用户");
        weekUserNumResp.setType("line");
        weekBorrowNumResp.setStack("用户");
        weekUserNumResp.setData(borrowInfoService.findWeekUsersNum());
        weekAllNums.add(weekUserNumResp);

        return weekAllNums;
    }
}
