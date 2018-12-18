package com.example.design.pattern.flyweight.factory;

import com.example.design.pattern.flyweight.IReportManager;
import org.junit.Test;

public class ReportManagerFactoryTest {

    @Test
    public void testFlyweight(){
        ReportManagerFactory reportManagerFactory = new ReportManagerFactory();
        IReportManager reportManager = reportManagerFactory.getFinancialReportManager("A");
        System.out.println(reportManager.createReport());
    }

}