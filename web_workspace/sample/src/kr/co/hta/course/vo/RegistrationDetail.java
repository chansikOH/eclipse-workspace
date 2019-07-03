package kr.co.hta.course.vo;

import java.util.Date;

public class RegistrationDetail {
	
	private int courseNo;
	private String courseTitle;
	private String courseStartDate;
	private String courseEndDate;
	private String courseImgName;
	private int regNo;
	private String memberId;
	private String regStatus;
	private Date regCreateDate;

	public RegistrationDetail() {
		super();
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	public Date getRegCreateDate() {
		return regCreateDate;
	}

	public void setRegCreateDate(Date regCreateDate) {
		this.regCreateDate = regCreateDate;
	}

	public String getCourseImgName() {
		return courseImgName;
	}

	public void setCourseImgName(String courseImgName) {
		this.courseImgName = courseImgName;
	}
	
	
}
