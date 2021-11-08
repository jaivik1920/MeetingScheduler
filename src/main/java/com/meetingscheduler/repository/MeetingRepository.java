package com.meetingscheduler.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meetingscheduler.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
	
	
	@Query("select m from Meeting m where m.hostUserEmail=:email and m.starttime=:time")
	public Meeting findByUserEmailAndStartTime(@Param("email") String email,@Param("time") Time time);
	
	@Query("select m from Meeting m where m.hostUserEmail=:email and m.endtime=:time")
	public Meeting findByUserEmailAndEndTime(@Param("email") String email,@Param("time") Time time);
	
	@Query("Select m from Meeting m where m.hostUserEmail=:email")
	public List<Meeting> findAllByUserEmail(@Param("email") String email);
	
	
	@Query("Select m from Meeting m where m.hostUserEmail=:email and  m.meetingdate=:date")
	public List<Meeting> findAllByUserEmailAndMeetingDate(@Param("email") String email,@Param("date") Date date);

}
