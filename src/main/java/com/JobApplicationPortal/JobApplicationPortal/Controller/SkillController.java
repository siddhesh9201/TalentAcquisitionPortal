package com.JobApplicationPortal.JobApplicationPortal.Controller;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.RecruiterOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.ClientMapper.SeekerProfileOutgoingDto;

import com.JobApplicationPortal.JobApplicationPortal.Mapper.SkillMapper.SkillIncomingDto;
import com.JobApplicationPortal.JobApplicationPortal.Mapper.SkillMapper.SkillOutgoingDto;
import com.JobApplicationPortal.JobApplicationPortal.Model.Skill;
import com.JobApplicationPortal.JobApplicationPortal.Services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seeker")
public class SkillController {
       @Autowired
       SkillServices skillServices;

       @GetMapping("/skill/getAll")
      public ResponseEntity<List<SkillOutgoingDto>> getAllSkills(){
          return ResponseEntity.status(HttpStatus.OK).body(skillServices.getAllSkills());
      }

      @PutMapping("/skill/update/{skillId}")
      public ResponseEntity<String> updateSkillbyId(@PathVariable Long skillId, @RequestBody SkillIncomingDto skillName){
            return  ResponseEntity.status(HttpStatus.OK).body(skillServices.updateSkillById(skillId,skillName));
      }

      @DeleteMapping("/skill/delete/{skillId}")
      public ResponseEntity<String> delteSkillById(@PathVariable Long skillId){
          return ResponseEntity.status(HttpStatus.CREATED).body(skillServices.deleteSkillbyId(skillId));
      }

}
