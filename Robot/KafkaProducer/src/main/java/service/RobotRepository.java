package service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<Robot, Integer> {

	public Optional<Robot> findById(Integer key);
}