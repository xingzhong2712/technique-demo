package com.example.concurrent.singlethreadexecution.demo;

/**
 * 类职责：<br/>
 *
 * <p>Title: FlightSecurity.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月11日 下午上午 9:30
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class FlightSecurity {

    private int count = 0;

    /**
     * 登机牌
     */
    private String boardingPass = "null";

    /**
     * 身份证
     */
    private String idCard = "null";

    public void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        check();
    }

    private void check() {
        // 测试：当登机牌和身份证首字母不相同时表示不通过
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("====Exception====" + toString());
        }
    }

    @Override
    public String toString() {
        return "The " + count + " passengers, boardingPass [" + boardingPass + "], idCard [" + idCard + "].";
    }
}
