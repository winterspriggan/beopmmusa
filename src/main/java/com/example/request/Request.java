package com.example.request;

public class Request {
    private String clientName;
    private String date;
    private String request;
    private String answer;
    private EventType type;

    public Request() {

    }

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

    public static int getCount(String type) {
        switch (type) {
            case "부동산 등기":
            case "상업 법인 등기":
                return 4;
            case "후견 등기":
            case "공탁 사건":
            case "개인파산 및 개인회생":
                return 1;
            case "동산, 채권 담보 등기":
                return 3;
            case "경매 공매":
            case "송무 비송 집행":
            case "상담 및 실비 변상":
                return 2;
            case "기타 대행업무":
                return 13;
            default:
                return 0;
        }
    }

    public static double getBasicCompensation(String type, double stTax, int i) {
        switch (type) {
            case "부동산 등기":
               return getRealEstateRegistration(stTax, i);
            case "상업 법인 등기":
                return getCommercialCorporationRegistration(stTax, i);
            case "후견 등기":
                return   getGuardianshipRegistration(stTax , i);
            case "동산, 채권 담보 등기":
                return   getMovableAssetsAndBondCollateral(stTax , i);
            case "공탁 사건":
                return   getDeposit(stTax , i);
            case "경매 공매":
                return   getLitigationNonLitigationExecution(stTax , i);
            case "송무 비송 집행":
                return   getPersonalBankruptcyAndPersonalRehabilitation(stTax , i);
            case "개인파산 및 개인회생":
                return   getPersonalBankruptcyAndPersonalRehabilitation(stTax , i);
            case "기타 대행업무":
                return   getOtherAgencyWork(stTax , i);
            case "상담 및 실비 변상":
                return  getConsultingFee(stTax , i);
            default:
                return 0;
        }
    }

    //부동산 등기 보수
    public static double getRealEstateRegistration(double stTax, int i) {
        switch (i) {
            case 1:
                if (stTax <= 10000000) return 100000; //10만원
                else if (stTax <= 50000000) return (100000.0 + stTax * (11.0 / 10000.0)); // 100000 + 과세표준액 ** 11/10000
                else if (stTax <= 100000000) return 144000.0 + stTax * (10.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (stTax <= 300000000) return 194000.0 + stTax * (9.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (stTax <= 500000000) return 374000.0 + stTax * (8.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (stTax <= 1000000000) return 534000.0 + stTax * (7.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (stTax <= 2000000000) return 884000.0 + stTax * (5.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (stTax <= 20000000000.0)
                    return 1384000.0 + stTax * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 8584000.0 + stTax * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                if (stTax <= 50000000.0) return 80000.0;
                else if (stTax <= 200000000.0) return 80000.0 + stTax * (5.0 / 10000.0);
                else if (stTax <= 1000000000.0) return 155000.0 + stTax * (2.0 / 10000.0);
                else if (stTax <= 10000000000.0) return 315000.0 + stTax * (1.0 / 10000.0);
                else return 1215000.0 + stTax * (1 / 20000.0);
            case 3:
                if (stTax == 1.0) return 80000.0;
                if (stTax == 2.0) return 100000.0;
                if (stTax == 3.0) return 30000.0;
                if (stTax == 4.0) return 50000.0;
            case 4:
                if (stTax == 1.0) return 100000.0;
                if (stTax == 2.0) return 70000.0;
                if (stTax == 3.0) return 220000.0;
                if (stTax == 4.0) return 40000.0;
                if (stTax == 5.0) return 70000.0;
            default:
                return 0;
        }
    }

    //상업 법인 등기 보수
    private static double getCommercialCorporationRegistration(double payment, int i) {
        switch (i) {
            case 1:
                if (payment <= 50000000) return 310000.0;
                else if (payment <= 100000000) return 310000.0 + payment * (22.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (payment <= 300000000) return 420000.0 + payment * (9.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (payment <= 500000000) return 600000.0 + payment * (8.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (payment <= 1000000000) return 760000.0 + payment * (7.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (payment <= 2000000000) return 1110000.0 + payment * (6.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (payment <= 20000000000.0)
                    return 1710000.0 + payment * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 8910000.0 + payment * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                if (payment <= 50000000) return 230000.0;
                else if (payment <= 100000000) return 230000.0 + payment * (19.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (payment <= 300000000) return 325000.0 + payment * (8.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (payment <= 500000000) return 485000.0 + payment * (7.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (payment <= 1000000000) return 625000.0 + payment * (6.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (payment <= 2000000000) return 925000.0 + payment * (5.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (payment <= 20000000000.0)
                    return 1425000.0 + payment * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 8625000.0 + payment * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 3:
                if (payment <= 100000000) return 120000.0;
                else if (payment <= 500000000) return 120000.0 + payment * (5.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (payment <= 2000000000) return 320000.0 + payment * (3.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (payment <= 10000000000.0)
                    return 770000.0 + payment * (2.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 2370000.0 + payment * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 4:
                if (payment == 1.0) return 250000.0;
                if (payment == 2.0) return 150000.0;
                if (payment == 3.0) return 120000.0;
                if (payment == 4.0) return 100000.0;
                if (payment == 5.0) return 70000.0;
                if (payment == 6.0) return 80000.0;
                if (payment == 7.0) return 60000.0;
                if (payment == 8.0) return 60000.0;
            default:
                return 0;
        }
    }

    //후견 등기 보수
    private static double getGuardianshipRegistration(double money, int i) {
        switch (i) {
            case 1:
                return 250000.0;
            case 2:
                return 100000.0;
            default:
                return 0.0;
        }
    }

    // 동산/채권 담보등기 보수

    private static double getMovableAssetsAndBondCollateral(double bondAmount, int i) {
        switch (i) {
            case 1:
                if (bondAmount <= 10000000) return 150000; //10만원
                else if (bondAmount <= 50000000) return (150000.0 + bondAmount * (10.0 / 10000.0)); // 100000 + 과세표준액 ** 11/10000
                else if (bondAmount <= 100000000) return 190000.0 + bondAmount * (9.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (bondAmount <= 300000000) return 235000.0 + bondAmount * (8.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (bondAmount <= 500000000) return 395000.0 + bondAmount * (7.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (bondAmount <= 1000000000) return 535000.0 + bondAmount * (6.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (bondAmount <= 2000000000) return 835000.0 + bondAmount * (5.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (bondAmount <= 20000000000.0)
                    return 1335000.0 + bondAmount * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 8535000.0 + bondAmount * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                if (bondAmount <= 10000000) return 100000; //10만원
                else if (bondAmount <= 50000000) return (100000.0 + bondAmount * (4.0 / 10000.0)); // 100000 + 과세표준액 ** 11/10000
                else if (bondAmount <= 200000000) return 116000.0 + bondAmount * (3.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (bondAmount <= 1000000000) return 161000.0 + bondAmount * (2.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (bondAmount <= 10000000000.0)
                    return 321000.0 + bondAmount * (1.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 1221000.0 + bondAmount * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 3:
                if (bondAmount == 1.0) return 100000.0;
                if (bondAmount == 2.0) return 70000.0;
            default:
                return 0;
        }
    }

    // 공탁사건의 보수
    private static double getDeposit(double depositValue, int i) {
        switch (i) {
            case 1:
                if (depositValue <= 50000000) return 100000.0;
                else if (depositValue <= 100000000) return 100000.0 + depositValue * (9.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (depositValue <= 300000000) return 145000.0 + depositValue * (8.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (depositValue <= 500000000) return 305000.0 + depositValue * (6.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (depositValue <= 1000000000) return 425000.0 + depositValue * (5.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (depositValue <= 2000000000) return 675000.0 + depositValue * (4.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (depositValue <= 20000000000.0)
                    return 1075000.0 + depositValue * (4.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 4275000.0 + depositValue * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            default:
                return 0;
        }
    }


    //경매,공매 사건의 보수 appraisedValue

    private static double getAuction(double appraisedValue, int i) {
        switch (i) {
            case 1:
                if (appraisedValue <= 50000000) return 400000.0;
                else if (appraisedValue <= 100000000) return 400000.0 + appraisedValue * (9.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (appraisedValue <= 300000000) return 850000.0 + appraisedValue * (8.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (appraisedValue <= 500000000) return 2450000.0 + appraisedValue * (7.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (appraisedValue <= 1000000000) return 3850000.0 + appraisedValue * (6.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (appraisedValue <= 2000000000) return 6850000.0 + appraisedValue * (4.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (appraisedValue <= 20000000000.0) return 10850000.0 + appraisedValue * (2.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 26850000.0 + appraisedValue * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                return 0; //매수인과 감정기액의 1% 이하 혹은 최저 매각가의 1.5% 이하 범위 내에서 의뢰인과 협의, 단 최고기 매수신고인 또는 매수인으로 되지 못한 경우에는 50만원 내에서 협의
            default:
                return 0;
        }
    }

    // 송무 비송 집행사건의 보수
    private static double getLitigationNonLitigationExecution(double lawsuitPrice, int i) {
        switch (i) {
            case 1:
                if (lawsuitPrice <= 20000000) return 400000.0;
                else if (lawsuitPrice <= 100000000) return 400000.0 + lawsuitPrice * (10.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (lawsuitPrice <= 500000000) return 480000.0 + lawsuitPrice * (9.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (lawsuitPrice <= 1000000000) return 840000.0 + lawsuitPrice * (4.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (lawsuitPrice <= 2000000000) return 1040000.0 + lawsuitPrice * (3.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else return 1340000.0 + lawsuitPrice * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 2:
                if (lawsuitPrice <= 20000000) return 180000.0;
                else if (lawsuitPrice <= 100000000) return 180000.0 + lawsuitPrice * (1.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (lawsuitPrice <= 500000000) return 188000.0 + lawsuitPrice * (5.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (lawsuitPrice <= 1000000000) return 380000.0 + lawsuitPrice * (4.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (lawsuitPrice <= 2000000000) return 580000.0 + lawsuitPrice * (2.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else return 780000.0 + lawsuitPrice * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            case 3:
                return 30000.0;
            default:
                return 0;
        }
    }


    //개인 파산 및 개인회생 사건의 보수
    private static double getPersonalBankruptcyAndPersonalRehabilitation(double debtAmount, int i) {
        switch (i) {
            case 1:
                if (debtAmount <= 20000000) return 800000; //10만원
                else if (debtAmount <= 50000000) return (800000.0 + debtAmount * (10.0 / 10000.0)); // 100000 + 과세표준액 ** 11/10000
                else if (debtAmount <= 100000000) return 830000.0 + debtAmount * (9.0 / 10000.0); // 144000 + 과세표준액 ** 10/10000
                else if (debtAmount <= 300000000) return 875000.0 + debtAmount * (8.0 / 10000.0);  // 194000 + 과세표준액 ** 9/10000
                else if (debtAmount <= 500000000) return 1035000.0 + debtAmount * (7.0 / 10000.0);  // 374000 + 과세표준액 ** 8/10000
                else if (debtAmount <= 1000000000) return 1175000.0 + debtAmount * (5.0 / 10000.0);  // 534000 + 과세표준액 ** 7/10000
                else if (debtAmount <= 1500000000) return 1425000.0 + debtAmount * (4.0 / 10000.0);  // 884000 + 과세표준액 ** 5/10000
                else if (debtAmount <= 2000000000.0) return 1625000.0 + debtAmount * (2.0 / 10000.0);  // 1384000 + 과세표준액 ** 4/10000
                else return 17205000.0 + debtAmount * (1.0 / 10000.0);  // 8584000 + 과세표준액 ** 1/10000
            default:
                return 0;
        }
    }

    //기타 대행업무 보수
    private static double getOtherAgencyWork(double nope, int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 9: return 40000;
            case 5: return 60000;
            case 10:
            case 11: return 50000;
            case 12: return 3000;
            case 8:
            case 13: return 30000;
            default: return 0;
        }
    }

    //상담 및 실비 변상 보수
    private static double getConsultingFee(double t, int i) {
        switch (i) {
            case 1:
                if(t < 30) return 50000;
                else return (50000+ 20000*((t-30)/30));
            case 2: return t*500000;
            case 3:
            default: return 0;
        }
    }
}
