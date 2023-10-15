package com.example.request;

public class Request {
    private String clientName;
    private String date;
    private String request;
    private String answer;

    private EventType type;

    public String getClientName() {
        return clientName;
    }

    public EventType getType() {
        return this.type;
    }

    public String getDate() {
        return date;
    }

    public String getRequest() {
        return request;
    }

    public String getAnswer() {
        return answer;
    }

    public Request(String clientName, String date, String request, String answer, EventType type) {
        this.clientName = clientName;
        this.date = date;
        this.request = request;
        this.answer = answer;
        this.type = type;
    }

    public double getBasicCompensation(EventType type, double stTax) {
        switch (type.getTitle()) {
            case "부동산 등기" :
                break;
            case "상업 법인 등기" :
                break;
            case "후견 등기" :
                break;
            case "동산, 채권 담보 등기" :
                break;
            case "공탁 사건" :
                break;
            case "경매 공매" :
                break;
            case "송무 비송 집행" :
                break;
            case "개인파산 및 개인회생" :
                break;
            case "기타 대행업무" :
                break;
            case "상담 및 실비 변상" :
                break;
            default: return 0;
        }
        return 0;

    }

    public static double getB(double stTax, int i) {
        switch (i) {
            case 1 :
                if (stTax <= 10000000) return 100000; //10만원
                else if (stTax <= 50000000) return (100000.0 + stTax * (11.0 / 10000.0)); // 100000 + 과세표준액 ** 11/10000
                else if (stTax <= 100000000) return 144000.0 + stTax * (10.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (stTax <= 300000000) return 194000.0 + stTax * (9.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (stTax <= 500000000) return 374000.0 + stTax * (8.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (stTax <= 1000000000) return 534000.0 + stTax * (7.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (stTax <= 2000000000) return 884000.0 + stTax * (5.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (stTax <= 20000000000.0) return 1384000.0 + stTax * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 8584000.0 + stTax * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                if (stTax <= 50000000.0) return 80000.0;
                else if(stTax <= 200000000.0) return 80000.0 + stTax * (5/10000.0);
                else if(stTax <= 1000000000.0) return 155000.0 + stTax * (2/10000.0);
                else if(stTax <= 10000000000.0) return 315000.0 + stTax * (1/10000.0);
                else return 1215000.0 + stTax * (1/20000.0);
            case 3:
                if(stTax==1.0) return 80000.0;
                if(stTax==2.0) return 100000.0;
                if(stTax==3.0) return 30000.0;
                if(stTax==4.0) return 50000.0;
        }
        return 0;
    }
}
