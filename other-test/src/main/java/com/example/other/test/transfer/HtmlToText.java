package com.example.other.test.transfer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 类职责：<br/>
 *
 * <p>Title: HtmlToText.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 浙江执御信息技术有限公司</p>
 * <p>Company: 浙江执御信息技术有限公司</p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年07月26日 下午下午 3:44
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */

public class HtmlToText {
    public static void main(String[] args) {
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
                "\t\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\"\n" +
                "  \t     data-page-model=\"multi-page\"    data-brandcode=\"doku_permata_lite_atm\"    \tdata-shopperlocale=\"id-ID\"\t    >\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "\n" +
                "\t<title></title>\n" +
                "\n" +
                "\t<link rel=\"shortcut icon\" href=\"/sf/kfgFAF0P/img/favicon.ico\" />\n" +
                "\t\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/hpp/css/reset.css?v=3bda\" />\n" +
                "\t<link rel=\"stylesheet\" media=\"screen\" type=\"text/css\" href=\"/sf/kfgFAF0P/css/screen.css\" />\n" +
                "\t<link rel=\"stylesheet\" media=\"print\"  type=\"text/css\" href=\"/sf/kfgFAF0P/css/print.css\" />\n" +
                "\t<link rel=\"stylesheet\" href=\"/hpp/css/voucher-framework.css\" type=\"text/css\" />\t<script type=\"text/javascript\" src=\"/hpp/js/default.js?v=3bda\"></script>\n" +
                "\t<!--[if lt IE 7]>\n" +
                "\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/sf/kfgFAF0P/css/screen_ie6.css\" />\n" +
                "\t<![endif]-->\n" +
                "</head>\n" +
                "\t<body id=\"voucher-framework\"> <script type=\"text/javascript\">\n" +
                "\t//<![CDATA[\t\n" +
                "\tvar clientIPAddress=\"115.236.62.130\";\n" +
                "\t\n" +
                "\tvar config = [];\n" +
                "\tconfig[\"pmmanimation\"] = 2;\n" +
                "\t\n" +
                "\t//]]>\n" +
                "  </script>\n" +
                "\n" +
                "    \n" +
                "    \t<div id=\"container\">\n" +
                "      \n" +
                "      <form id=\"pageform\" action=\"select.shtml\" method=\"post\"  autocomplete=\"off\" onsubmit=\"return formValidate(this , 'doku_permata_lite_atm' );\">\n" +
                "      <div id=\"content\" >\n" +
                "\t\t\t\t<div id=\"logoheader\"></div>\n" +
                "<div id=\"pmcontent\">\t\t\t<div class=\"paddiv1\"></div>\n" +
                "\t\t\t\n" +
                "\n" +
                "            <div class=\"wrapper\">\n" +
                "    <h1 class=\"headline\">Your order of <em>Rp 100</em> has been placed</h1>\n" +
                "    <p>\n" +
                "        Thank you for your order! It will be delivered after you have made your payment. Please pay by <em>26/7/2018 20:28</em> (GMT+7) at any of the following ATM’s, internet or mobile banking facilities: Alto, Bersama, Prima, using the unique payment code below.\n" +
                "    </p>\n" +
                "    <p class=\"no-margin\">\n" +
                "        We have sent an email to\n" +
                "\n" +
                "            you\n" +
                "            with these details and payment instructions.\n" +
                "    </p>\n" +
                "\n" +
                "    <div class=\"tac\">\n" +
                "        <div class=\"payment-detail-code\">\n" +
                "            <em>8965 0260 3002 7525</em>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"tac payment-details\">\n" +
                "        <div class=\"dib mr\">\n" +
                "\n" +
                "            <div class=\"payment-detail-icon\">\n" +
                "                <img class=\"icon\" width=\"20\" src=\"/hpp/img/voucher/icon-bank.png\">\n" +
                "            </div>\n" +
                "\n" +
                "            <span class=\"payment-detail-label\">Bank code</span>\n" +
                "\n" +
                "            <em class=\"payment-detail-cost\">013</em>\n" +
                "\n" +
                "        </div><div class=\"dib mr\">\n" +
                "\n" +
                "            <div class=\"payment-detail-icon\">\n" +
                "                <img class=\"icon\" width=\"20\" src=\"/hpp/img/voucher/icon-wallet.png\">\n" +
                "            </div>\n" +
                "\n" +
                "            <span class=\"payment-detail-label\">Amount</span>\n" +
                "\n" +
                "            <em class=\"payment-detail-cost\">Rp 100</em>\n" +
                "\n" +
                "        </div><div class=\"dib\">\n" +
                "\n" +
                "        <div class=\"payment-detail-icon\">\n" +
                "            <img class=\"icon\" width=\"20\" src=\"/hpp/img/voucher/icon-calendar.png\">\n" +
                "        </div>\n" +
                "\n" +
                "        <span class=\"payment-detail-label\">Pay before (GMT+7)</span>\n" +
                "\n" +
                "        <em class=\"payment-detail-time\">26/7/2018 20:28</em>\n" +
                "    </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <hr class=\"dashed\">\n" +
                "\n" +
                "    <div class=\"tac\">\n" +
                "        <img src=\"/hpp/img/voucher/dokuATM_logo.jpg\" width=\"106px\" alt=\"Permata\" title=\"Permata\"/>\n" +
                "    </div>\n" +
                "\n" +
                "    <h2 class=\"h4 payment-instructions-heading\">\n" +
                "        <img class=\"mr-half icon\" src=\"/hpp/img/voucher/icon-atm.png\" width=\"20\">\n" +
                "        Pay at the ATM\n" +
                "    </h2>\n" +
                "\n" +
                "    <ol class=\"payment-instructions-list\">\n" +
                "        <li>\n" +
                "            Choose the following path:<br>\n" +
                "            <ul>\n" +
                "                <li>Bersama, Prima, Alto: <em>Transfer > Other Bank Account</em></li>\n" +
                "                <li>BCA: <em>Other > Transfer</em></li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            Enter these payment details to complete the payment:\n" +
                "            <ul>\n" +
                "                <li>Bank code: <em>013 Bank Permata</em></li>\n" +
                "                <li>Payment Code: <em>8965 0260 3002 7525</em></li>\n" +
                "                <li>Amount: <em>Rp 100</em> (enter the exact amount)</li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            Keep your receipt as a proof of payment. The merchant will be directly notified of the payment status.\n" +
                "        </li>\n" +
                "    </ol>\n" +
                "\n" +
                "    <h2 class=\"h4 payment-instructions-heading\">\n" +
                "        <img class=\"mr-half icon\" src=\"/hpp/img/voucher/icon-mobile.png\" width=\"20\">\n" +
                "        Pay using internet or mobile banking (not available for KlikBCA)\n" +
                "    </h2>\n" +
                "\n" +
                "    <ol class=\"payment-instructions-list\">\n" +
                "        <li>\n" +
                "            Choose the following path\n" +
                "            <em>Transfer > Between Permata Bank Accounts.</em>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            Enter these payment details to complete the payment:\n" +
                "            <ul>\n" +
                "                <li>Bank code: <em>013 Bank Permata</em></li>\n" +
                "                <li>Payment Code: <em>8965 0260 3002 7525</em></li>\n" +
                "                <li>Amount: <em>Rp 100</em> (enter the exact amount)</li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "        <li>\n" +
                "            Review your payment details and complete the payment\n" +
                "        </li>\n" +
                "    </ol>\n" +
                "</div>\n" +
                "    \n" +
                "\n" +
                "    <a class=\"footerB\" style=\"float: right; line-height: 36px;\" href=\"http://test.com?authResult=PENDING&amp;merchantReference=409f4e39848a451d984e1ab30e87fc3e&amp;merchantSig=dbzTeSqtMYzN70lXpTdeLXn%2BuF6WF5cCYbVKUlmaeMg%3D&amp;paymentMethod=doku_permata_lite_atm&amp;pspReference=8515325900843932&amp;shopperLocale=id-ID&amp;skinCode=kfgFAF0P\">Continue to merchant</a>\n" +
                "\n" +
                "  <div class=\"paddiv2\"></div>\n" +
                "  \t</div>    </div>\n" +
                "    </form>\n" +
                "    \t</div>  </body>\n" +
                "</html>";
        convert(html);
    }

    static String convert(String html){
        Document doc = Jsoup.parse(html);

        System.out.println(doc.toString());

        Elements elements = doc.getElementsByTag("em");
        StringBuilder sb = new StringBuilder();
        for (Element element : elements) {
            sb.append(element.text());
        }

//        doc.get

        System.out.println("em:::" + sb.toString());

        return sb.toString();
    }
}
