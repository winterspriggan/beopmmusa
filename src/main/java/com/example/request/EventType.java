package com.example.request;

public enum EventType {

    //부동산 등기
    RealEstateRegistration("부동산 등기"),

    //상업 법인 등기
    CommercialCorporationRegistration("상업 법인 등기"),

    //후견 등기
    GuardianshipRegistration("후견 등기"),

    //동산, 채권 담보 등기
    MovableAssetsAndBondCollateral("동산, 채권 담보 등기"),

    //공탁 사건
    Deposit("공탁 사건"),

    //경매 공매
    Auction("경매 공매"),

    //송무 비송 집행
    LitigationNonLitigationExecution("송무 비송 집행"),

    //개인파산 및 개인회생

    PersonalBankruptcyAndPersonalRehabilitation("개인파산 및 개인회생"),

    //기타 대행업무

    OtherAgencyWork("기타 대행업무"),

    //상담 및 실비 변상

    Consultation("상담 및 실비 변상");

    private String title;

    EventType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }






}
