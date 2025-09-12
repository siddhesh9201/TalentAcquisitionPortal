package com.JobApplicationPortal.JobApplicationPortal.Repository;

import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
    boolean existsByTitleAndCompanyName(@NotNull  String title, @NotNull  String companyName);
    @Query("SELECT j FROM Job j WHERE LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%')) AND LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))")
    Page<Job> searchJobs(@Param("title") String title,
                         @Param("location") String location,
                         Pageable pageable);

}
