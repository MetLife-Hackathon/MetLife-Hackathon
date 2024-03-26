package net.azurewebsites.appmetlifeteam10.consulting.presentation.dto;

import net.azurewebsites.appmetlifeteam10.consulting.domain.CustomerInfo;

public record ReadConsultantResponse(Long memberId, String name, int age, String joinedInsurance, String summary) {
    public static ReadConsultantResponse from(final CustomerInfo customerInfo) {
        return new ReadConsultantResponse(
                customerInfo.customerId(),
                customerInfo.customerName(),
                customerInfo.age(),
                customerInfo.insurances(),
                customerInfo.summary()
        );
    }
}
