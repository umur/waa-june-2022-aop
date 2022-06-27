package edu.miu.Lab05.repo;

import edu.miu.Lab05.entity.LabAop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ActiviyLogRepo extends JpaRepository<LabAop,Integer> {
}
