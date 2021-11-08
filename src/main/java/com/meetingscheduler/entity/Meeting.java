package com.meetingscheduler.entity;



import java.sql.Date;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User_Meeting")
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String hostUserEmail;
	
	private String meetingtitle;
	
	@Column(nullable = false)
	private String attandeeUserEmails;
	
	private Time starttime;
	private Time endtime;
	private Date meetingdate;
	private String meetinglink;
	
	
 
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(int id, String hostUserEmail, String attandeeUserEmails, Time starttime, Time endtime,
			Date meetingdate,String meetingtitle,String meetinglink) {
		super();
		this.id = id;
		this.hostUserEmail = hostUserEmail;
		this.attandeeUserEmails = attandeeUserEmails;
		this.starttime = starttime;
		this.endtime = endtime;
		this.meetingdate = meetingdate;
		this.meetingtitle=meetingtitle;
		this.meetinglink=meetinglink;
	}

	public Meeting(String hostUserEmail, String attandeeUserEmails, Time starttime, Time endtime,
			Date meetingdate,String meetingtitle,String meetinglink) {
		super();
		this.hostUserEmail = hostUserEmail;
		this.attandeeUserEmails = attandeeUserEmails;
		this.starttime = starttime;
		this.endtime = endtime;
		this.meetingdate = meetingdate;
		this.meetingtitle=meetingtitle;
		this.meetinglink=meetinglink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostUserEmail() {
		return hostUserEmail;
	}

	public void setHostUserEmail(String hostUserEmail) {
		this.hostUserEmail = hostUserEmail;
	}

	public String getAttandeeUserEmails() {
		return attandeeUserEmails;
	}

	public void setAttandeeUserEmails(String attandeeUserEmails) {
		this.attandeeUserEmails = attandeeUserEmails;
	}

	public Time getStarttime() {
		return starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public Time getEndtime() {
		return endtime;
	}

	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}

	public Date getMeetingdate() {
		return meetingdate;
	}

	public void setMeetingdate(Date meetingdate) {
		this.meetingdate = meetingdate;
	}

	
	public String getMeetingtitle() {
		return meetingtitle;
	}

	public void setMeetingtitle(String meetingtitle) {
		this.meetingtitle = meetingtitle;
	}

	
	public String getMeetinglink() {
		return meetinglink;
	}

	public void setMeetinglink(String meetinglink) {
		this.meetinglink = meetinglink;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", hostUserEmail=" + hostUserEmail + ", meetingtitle=" + meetingtitle
				+ ", attandeeUserEmails=" + attandeeUserEmails + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", meetingdate=" + meetingdate + ", meetinglink=" + meetinglink + "]";
	}

	

	
	
	
	
}
