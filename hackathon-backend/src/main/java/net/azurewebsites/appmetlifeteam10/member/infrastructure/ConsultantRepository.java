package net.azurewebsites.appmetlifeteam10.member.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import net.azurewebsites.appmetlifeteam10.member.domain.Consultant;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Consultant findByName(final String consultantName);
}
