package com.meetingscheduler.controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meetingscheduler.entity.Meeting;
import com.meetingscheduler.entity.User;
import com.meetingscheduler.repository.MeetingRepository;
import com.meetingscheduler.repository.UserRepository;

@RestController
public class Controller {
	
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private MeetingRepository meetingrepo;
	
	@GetMapping("/test")
	public User test() {
		return userrepo.findByUserEmail("pateljaivik2025@gmail.com");
	}
	
	@PostMapping("/createmeeting")
	public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting){
		try {
		if(meetingrepo.findByUserEmailAndStartTime(meeting.getHostUserEmail(), meeting.getStarttime())!=null) {
			Meeting meeting2=meetingrepo.findByUserEmailAndStartTime(meeting.getHostUserEmail(), meeting.getStarttime());
			String s1=meeting2.getMeetingdate().toString();
			String s2=meeting.getMeetingdate().toString();
			if(s1.equals(s2)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		List<Meeting> meetings=meetingrepo.findAllByUserEmail(meeting.getHostUserEmail());
		for(Meeting meeting2:meetings) {
			String s1=meeting2.getMeetingdate().toString();
			String s2=meeting.getMeetingdate().toString();
			if((meeting.getStarttime().compareTo(meeting2.getStarttime())==0 && s1.equals(s2)) ||
			 (meeting.getStarttime().compareTo(meeting2.getStarttime())<0 && meeting.getEndtime().compareTo(meeting2.getStarttime())>0 && s1.equals(s2))||
			 (meeting.getStarttime().compareTo(meeting2.getStarttime())>0 && meeting.getStarttime().compareTo(meeting2.getEndtime())<0  && s1.equals(s2))) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		Meeting meeting2=meetingrepo.save(meeting);
		return ResponseEntity.of(Optional.of(meeting2));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping("/deletemeeting")
	
	public ResponseEntity<Meeting> deleteMeeting(@RequestBody Meeting meeting){
		try {
			
			int id=meeting.getId();
			meetingrepo.deleteById(id);	
			return ResponseEntity.status(HttpStatus.OK).build();
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			// TODO: handle exception
		}
	}
	
	
	
	@PostMapping("updatemeeting")
	
	public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting){
		try {
			
			
			List<Meeting> meetings=meetingrepo.findAllByUserEmail(meeting.getHostUserEmail());
			for(Meeting meeting2:meetings) {
				String s1=meeting2.getMeetingdate().toString();
				String s2=meeting.getMeetingdate().toString();
				if((meeting.getStarttime().compareTo(meeting2.getStarttime())==0 && s1.equals(s2)) ||
				 (meeting.getStarttime().compareTo(meeting2.getStarttime())<0 && meeting.getEndtime().compareTo(meeting2.getStarttime())>0 && s1.equals(s2))||
				 (meeting.getStarttime().compareTo(meeting2.getStarttime())>0 && meeting.getStarttime().compareTo(meeting2.getEndtime())<0  && s1.equals(s2))) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}
			Meeting meeting2=meetingrepo.save(meeting);
			return ResponseEntity.of(Optional.of(meeting2));
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/adduser")
	
	public ResponseEntity<User> addUser(@RequestBody User user){
		try {
			
			User user2=userrepo.save(user);
			return ResponseEntity.of(Optional.of(user2));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/getallmeetings")
	public ResponseEntity<List<Meeting>> getAllMeeting(@RequestBody User user){
		
		try {
			
			List<Meeting> meetings=meetingrepo.findAllByUserEmail(user.getUserEmail());
			
			if(meetings.size()==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			else {
				return ResponseEntity.of(Optional.of(meetings));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/finduser")
	public ResponseEntity<User> findUser(@RequestBody User user1){
		
		try {
			User user=userrepo.findByUserAuthId(user1.getUserAuthid());
			if(user!=null) {
				return ResponseEntity.of(Optional.of(user));
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/getallmeetingsbydate")
	public ResponseEntity<List<Meeting>> getAllMeetingByDate(@RequestBody Meeting meeting){
		try {
			List<Meeting> meetings=meetingrepo.findAllByUserEmailAndMeetingDate(meeting.getHostUserEmail(),meeting.getMeetingdate());
			if(meetings.size()==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			else {
				return ResponseEntity.of(Optional.of(meetings));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}


