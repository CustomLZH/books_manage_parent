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
        weekBorrowNumResp.setData(borrowInfoService.findWeekBorrowNum());
        weekAllNums.add(weekBorrowNumResp);

        TreeSet<WeekNumResp> weekNullNum = new TreeSet<>();
        TreeSet<WeekNumResp> weekNullNum1 = new TreeSet<>();
        TreeSet<WeekNumResp> weekNullNum2 = new TreeSet<>();
        List<Date> sevenDays = DateUtil.getSevenDays();
        int todayWeek = DateUtil.getTodayWeek();
        String[] weekNames = new String[] {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        for (Date sevenDay : sevenDays) {
            int week = DateUtil.getTodayWeek(sevenDay);
            String weekName = weekNames[week - 1];
            if (week > todayWeek) {
                weekName = "上" + weekName;
            }
            weekNullNum.add(new WeekNumResp(sevenDay, 0, week, weekName));
            weekNullNum1.add(new WeekNumResp(sevenDay, 0, week, weekName));
            weekNullNum2.add(new WeekNumResp(sevenDay, 0, week, weekName));
        }

        // 添加挂失信息
        WeekAllNumResp weekRestoreNumResp = new WeekAllNumResp();
        weekRestoreNumResp.setName("归还");
        weekRestoreNumResp.setType("line");
        weekRestoreNumResp.setData(weekNullNum);
        weekAllNums.add(weekRestoreNumResp);

        // 添加挂失信息
        WeekAllNumResp weekLoseNumResp = new WeekAllNumResp();
        weekLoseNumResp.setName("挂失");
        weekLoseNumResp.setType("line");
        weekLoseNumResp.setData(weekNullNum1);
        weekAllNums.add(weekLoseNumResp);

        // 添加挂失信息
        WeekAllNumResp weekUserNumResp = new WeekAllNumResp();
        weekUserNumResp.setName("用户");
        weekUserNumResp.setType("line");
        weekUserNumResp.setData(weekNullNum2);
        weekAllNums.add(weekUserNumResp);


        return weekAllNums;
    }
}
