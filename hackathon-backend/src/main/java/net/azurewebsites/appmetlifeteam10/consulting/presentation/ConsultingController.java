package net.azurewebsites.appmetlifeteam10.consulting.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.azurewebsites.appmetlifeteam10.consulting.application.ConsultingService;
import net.azurewebsites.appmetlifeteam10.consulting.domain.CustomerInfo;
import net.azurewebsites.appmetlifeteam10.consulting.presentation.dto.CreateMatchingConsultantRequest;
import net.azurewebsites.appmetlifeteam10.consulting.presentation.dto.CreateMatchingConsultantResponse;
import net.azurewebsites.appmetlifeteam10.consulting.presentation.dto.ReadConsultantResponse;
import net.azurewebsites.appmetlifeteam10.consulting.presentation.dto.ReadConsultantResponses;
import net.azurewebsites.appmetlifeteam10.member.application.ConsultantService;
import net.azurewebsites.appmetlifeteam10.member.domain.Consultant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultings")
public class ConsultingController {

    private static final long MEMBER_ID = 1L;
    private final ConsultingService consultingService;
    private final ConsultantService consultantService;

    @GetMapping("{consultantId}")
    public ResponseEntity<ReadConsultantResponses> readConsultantInfo(@PathVariable final Long consultantId) {
        final List<CustomerInfo> consultingInfos = consultingService.read(consultantId);
        final List<ReadConsultantResponse> responses = consultingInfos.stream()
                .map(ReadConsultantResponse::from)
                .toList();

        return ResponseEntity.ok(new ReadConsultantResponses(responses));
    }

    @PostMapping
    public ResponseEntity<CreateMatchingConsultantResponse> createMatchingConsultant(
            @RequestBody final CreateMatchingConsultantRequest requests
    ) {
        final Consultant matchingConsultant = consultantService.matchConsultant();
        consultingService.create(MEMBER_ID, matchingConsultant, requests);
        final String consultantName = matchingConsultant.getName();

        return ResponseEntity.ok(new CreateMatchingConsultantResponse(consultantName));
    }
}
