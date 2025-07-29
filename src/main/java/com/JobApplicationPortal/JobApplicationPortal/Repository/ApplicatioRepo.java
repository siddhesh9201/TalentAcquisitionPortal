package com.JobApplicationPortal.JobApplicationPortal.Repository;

import com.JobApplicationPortal.JobApplicationPortal.Model.Application;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicatioRepo extends JpaRepository<Application,Long>{


    List<Application> findByClient(Client client);

    List<Application> findByJob(Job job);
}
