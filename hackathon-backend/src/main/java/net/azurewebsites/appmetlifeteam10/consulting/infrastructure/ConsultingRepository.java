package net.azurewebsites.appmetlifeteam10.consulting.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import net.azurewebsites.appmetlifeteam10.consulting.domain.Consulting;

import java.util.List;

public interface ConsultingRepository extends JpaRepository<Consulting, Long> {

    List<Consulting> findAllByConsultantId(final Long consultantId);
}
