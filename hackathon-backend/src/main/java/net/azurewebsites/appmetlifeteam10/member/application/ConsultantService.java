package net.azurewebsites.appmetlifeteam10.member.application;

import lombok.RequiredArgsConstructor;
import net.azurewebsites.appmetlifeteam10.member.domain.Consultant;
import net.azurewebsites.appmetlifeteam10.member.infrastructure.ConsultantRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsultantService {

    private static final String CONSULTANT_NAME = "보험설계사";

    private final ConsultantRepository consultantRepository;

    public Consultant matchConsultant() {
        return consultantRepository.findByName(CONSULTANT_NAME);
    }
}
