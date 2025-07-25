package com.JobApplicationPortal.JobApplicationPortal.Repository;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    Optional<Client> findByEmail(@Email @NotNull String email);


}
