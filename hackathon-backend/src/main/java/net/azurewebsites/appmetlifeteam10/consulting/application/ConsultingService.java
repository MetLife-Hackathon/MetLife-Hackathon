package net.azurewebsites.appmetlifeteam10.consulting.application;

import lombok.RequiredArgsConstructor;
import net.azurewebsites.appmetlifeteam10.consulting.domain.Consulting;
import net.azurewebsites.appmetlifeteam10.consulting.domain.CustomerInfo;
import net.azurewebsites.appmetlifeteam10.consulting.infrastructure.ConsultingRepository;
import net.azurewebsites.appmetlifeteam10.consulting.infrastructure.api.RestTemplateOpenAiProcessor;
import net.azurewebsites.appmetlifeteam10.consulting.presentation.dto.CreateMatchingConsultantRequest;
import net.azurewebsites.appmetlifeteam10.member.domain.Consultant;
import net.azurewebsites.appmetlifeteam10.member.domain.Customer;
import net.azurewebsites.appmetlifeteam10.member.infrastructure.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultingService {

    private static final String HISTORY_POSTFIX = "당신은 지금까지 이 고객과 {start}부터 {end} 사이에 있는 내용에 대해서 이야기를 나눴습니다. {start}";
    private static final String QUESTION_POSTFIX = "{end}이 고객이 당신에게 이렇게 질문하고 있습니다.";

    private final ConsultingRepository consultingRepository;
    private final CustomerRepository customerRepository;
    private final RestTemplateOpenAiProcessor openAiProcessor;

    public void create(final Long memberId, final Consultant matchingConsultant, final CreateMatchingConsultantRequest request) {
        final StringBuilder prompt = new StringBuilder();
        prompt.append(HISTORY_POSTFIX)
                .append(request.history())
                .append(QUESTION_POSTFIX)
                .append(request.question());
        final String summary = openAiProcessor.summarize(prompt.toString());
        final Consulting consulting = new Consulting(matchingConsultant.getId(), memberId, summary);
        consultingRepository.save(consulting);
    }

    public List<CustomerInfo> read(final Long consultantId) {
        final List<Consulting> consultingInfos = consultingRepository.findAllByConsultantId(consultantId);

        return createCustomerInfo(consultingInfos);
    }

    private List<CustomerInfo> createCustomerInfo(final List<Consulting> consultingInfos) {
        final List<CustomerInfo> customerInfos = new ArrayList<>();
        for (final Consulting consulting : consultingInfos) {
            final Customer customer = customerRepository.findById(consulting.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 고객 정보입니다."));
            final CustomerInfo customerInfo = new CustomerInfo(
                    consulting.getId(),
                    consulting.getConsultantId(),
                    customer.getId(),
                    customer.getName(),
                    customer.calculateAge(),
                    customer.getEmail(),
                    customer.getPassword(),
                    customer.getInsurances(),
                    consulting.getSummary()
            );
            customerInfos.add(customerInfo);
        }

        return customerInfos;
    }
}
