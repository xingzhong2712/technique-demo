package com.example.concurrent.singlethreadexecution.test;

import com.example.concurrent.singlethreadexecution.demo.FlightSecurity;

/**
 * 类职责：<br/>
 *
 * <p>Title: FlightSecurityTest.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午上午 10:15
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class FlightSecurityTest {

    public static void main(String[] args) {
        FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity, "A123456", "AF123456").start();
        new Passengers(flightSecurity, "B123456", "BF123456").start();
        new Passengers(flightSecurity, "C123456", "CF123456").start();
    }

    static class Passengers extends Thread {

        /**
         * 机场安检类
         */
        private final FlightSecurity flightSecurity;

        private final String idCard;

        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run() {
            while (true) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }
}
