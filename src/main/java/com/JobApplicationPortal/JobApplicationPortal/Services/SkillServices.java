package com.JobApplicationPortal.JobApplicationPortal.Services;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.SkillMapper.SkillIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.SkillMapper.SkillOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Client;
import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import com.JobApplicationPortal.JobApplicationPortal.Repository.ClientRepo;
import com.JobApplicationPortal.JobApplicationPortal.Repository.SkillRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServices {

    @Autowired
    SkillRepo skillRepo;



    @Autowired
    ModelMapper modelMapper;

    public List<SkillOutgoingDto> getAllSkills() {
        List<Skill> skills = skillRepo.findAll();
        return skills.stream().map((skill)->modelMapper.map(skill, SkillOutgoingDto.class)).toList();
    }

    public String updateSkillById(Long skillId, SkillIncomingDto skillName) {
        Skill skill= skillRepo.findById(skillId).orElseThrow(()-> new RuntimeException("Skill Not found"));

          skill.setName(skillName.getName());
          skillRepo.save(skill);
          return "Skill Updated Successfully";
    }


    public String deleteSkillbyId(Long skillId) {
        skillRepo.findById(skillId).orElseThrow(()->new RuntimeException("skill Not Found"));
        skillRepo.deleteById(skillId);
        return "Skill deleted SuccessFully!";
    }



}
