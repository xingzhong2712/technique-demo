package com.example.design.pattern.flyweight.impl;

import com.example.design.pattern.flyweight.IReportManager;

/**
 * 类职责：<br/>
 *
 * <p>Title: FinancialReportManagerImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月09日 下午上午 10:23
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class FinancialReportManagerImpl implements IReportManager {

    protected String tenantId;

    public FinancialReportManagerImpl(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report .";
    }

}
