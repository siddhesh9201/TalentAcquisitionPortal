package com.JobApplicationPortal.JobApplicationPortal.Repository;

import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {

    Optional<Skill> findByName(String skillName);
}
