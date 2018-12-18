package com.example.design.pattern.flyweight.factory;

import com.example.design.pattern.flyweight.IReportManager;
import com.example.design.pattern.flyweight.impl.EmployeeReportManagerImpl;
import com.example.design.pattern.flyweight.impl.FinancialReportManagerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 类职责：<br/>
 *
 * <p>Title: ReportManagerFactory.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 10:26
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class ReportManagerFactory {
    Map<String, IReportManager> financialReportManager = new HashMap<>();

    Map<String, IReportManager> employeeReportManager = new HashMap<>();

    IReportManager getFinancialReportManager(String tenantId){
        IReportManager r = financialReportManager.get(tenantId);
        if (r == null){
            r = new FinancialReportManagerImpl(tenantId);
            financialReportManager.put(tenantId, r);
        }

        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId){
        IReportManager r = financialReportManager.get(tenantId);
        if (r == null){
            r = new EmployeeReportManagerImpl(tenantId);
            employeeReportManager.put(tenantId, r);
        }

        return r;
    }

}
