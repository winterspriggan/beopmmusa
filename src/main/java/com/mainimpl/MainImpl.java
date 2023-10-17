package com.mainimpl;
import com.example.request.EventType;
import com.example.request.Request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainImpl {
    public MainImpl() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--Menu--");
        System.out.println("1. 의뢰 입력");
        System.out.println("2 ..");
        String input = br.readLine();
        if(input .equals("1")) newRequest();
        else {
            System.out.println("잘 못 입력하셨습니다.");
        }
    }
    public static EventType sort(int n) {
        switch (n) {
            case 1 :return EventType.RealEstateRegistration;
            case 2: return EventType.CommercialCorporationRegistration;
            case 3: return EventType.GuardianshipRegistration;
            case 4: return EventType.MovableAssetsAndBondCollateral;
            case 5: return EventType.Deposit;
            case 6: return EventType.Auction;
            case 7: return EventType.LitigationNonLitigationExecution;
            case 8: return EventType.PersonalBankruptcyAndPersonalRehabilitation;
            case 9: return EventType.OtherAgencyWork;
            case 10: return EventType.Consultation;
            default: return null;
        }
    }
    public static void newRequest() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("의뢰자의 이름을 입력하여 주십시오.");
        String clientName = br.readLine();
        System.out.println("의뢰 날짜를 입력하여 주십시오.");
        String date = br.readLine();
        System.out.println("의뢰 종류를 선택하여 주십시오");
        EventType eventType;
        while(true) {
            System.out.println("1.부동산 등기\n2.상업 법인 등기\n3.후견 등기\n4.동산 채권 담보 등기\n5.공탁 사건\n6.경매 공매 \n7.송무 비송 집행 \n8.개인파산 및 개인회생 \n9.기타 대행업무 \n10.상담 및 실비 변상 ");
            String type = br.readLine();
            try {
                if(!((Integer.parseInt(type) < 11 && Integer.parseInt(type)>0))) System.out.println("잘못된 입력입니다. 다시 입력하여 주십시오.");
                else {
                    eventType = sort(Integer.parseInt(type));
                    break;
                }
            } catch(NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하여 주십시오.");
            }
        }
        System.out.println("의뢰 상세 내역을 입력하여 주십시오.");
        String requests = br.readLine();
        System.out.println("답변을 입력하여 주십시오.");
        String answer = br.readLine();

        Request request = new Request(clientName, date, requests, answer, eventType);

        System.out.println("의뢰 상세 내역을 확인하여 주십시오.");
        System.out.println("의뢰자 : "+request.getClientName());
        System.out.println("의뢰 날짜 : "+request.getDate());
        System.out.println("의뢰 종류 : "+request.getType().getTitle());
        System.out.println("의뢰 내용 : " + request.getRequest());
        System.out.println("답변 : " + request.getAnswer());
        if(request.getType().getTitle().equals("부동산 등기")) {
            System.out.println("1.부동산 등기");
            System.out.println("2.담보권의 추가 설정 등기");
            System.out.println("3.기타 등기");
            int i = Integer.parseInt(br.readLine());
            double stTax = 0;
            switch (i) {
                case 2 :
                case 1 :
                    System.out.println("과세 표준액을 입력하여 주십시오");
                    break;
                case 3 :
                    System.out.println("1.재산의 분할/합병/목록 변경");
                    System.out.println("2. 권리의 변경/경정 또는 회복");
                    System.out.println("3. 부동산의 표시 또는 등명의인 표시의 변경/경정");
                    System.out.println("4. 말소등기");
                    break;
            }
            stTax = Double.parseDouble(br.readLine());
            System.out.println("대한 법무사협회 기준 기본 보수는 " + Request.getRealEstateRegistration(stTax, i) + " 원 입니다.");
        }


    }
}
