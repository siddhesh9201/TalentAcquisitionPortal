package com.JobApplicationPortal.JobApplicationPortal.Repository;

import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
    boolean existsByTitleAndCompanyName(@NotNull  String title, @NotNull  String companyName);
}
