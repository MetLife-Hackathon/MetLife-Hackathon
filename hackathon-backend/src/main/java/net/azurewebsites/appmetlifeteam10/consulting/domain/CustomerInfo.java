package net.azurewebsites.appmetlifeteam10.consulting.domain;

public record CustomerInfo(
        Long consultingId,
        Long consultantId,
        Long customerId,
        String customerName,
        int age,
        String email,
        String password,
        String insurances,
        String summary
) {
}
