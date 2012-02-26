package com.example.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
	private static final long serialVersionUID = 2245968279038794140L;

	private int id;

	private String firstName;
	private String lastName;
	private String ssn;
	private Date birthday;
	private String stdNo;
	private Date entranceDate;
	private byte[] encryptedCode;
	private Phone phone;

	// zero-argument constructor
	public Student() {
	}

	public Student(String firstName, String lastName, String ssn, Date birthday, String stdNo, Date entranceDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setSsn(ssn);
		setBirthday(birthday);
		setStdNo(stdNo);
		setEntranceDate(entranceDate);
	}

	@Id
	@SequenceGenerator(name = "seqId", sequenceName = " SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
	// @TableGenerator(name="keys", table="KEYS_TBL")
	// @GeneratedValue(strategy= GeneratorType.TABLE,generator="keys")
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public Date getEntranceDate() {
		return entranceDate;
	}

	public void setEntranceDate(Date entranceDate) {
		this.entranceDate = entranceDate;
	}

	@Lob
	public byte[] getEncryptedCode() {
		return encryptedCode;
	}

	public void setEncryptedCode(byte[] encryptedCode) {
		this.encryptedCode = encryptedCode;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Transient
	public int getAge() {
		Calendar c = Calendar.getInstance();
		c.setTime(new java.util.Date(getBirthday().getTime()));
		int birthYear = c.get(Calendar.YEAR);
		c.setTime(new java.util.Date());
		int now = c.get(Calendar.YEAR);
		return now - birthYear;
	}

	public String toString() {
		return id + ":" + firstName + ":" + lastName + ":" + ssn + ":[" + birthday + "]:"+ phone;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		final Student student = (Student) o;
		if (id == 0)
			return false;
		if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null)
			return false;
		if (entranceDate != null ? !entranceDate.equals(student.entranceDate) : student.entranceDate != null)
			return false;
		if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null)
			return false;
		if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null)
			return false;
		if (ssn != null ? !ssn.equals(student.ssn) : student.ssn != null)
			return false;
		if (stdNo != null ? !stdNo.equals(student.stdNo) : student.stdNo != null)
			return false;
		return true;
	}

	public int hashCode() {
		int result = id;
		result = 29 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 29 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 29 * result + (ssn != null ? ssn.hashCode() : 0);
		result = 29 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 29 * result + (stdNo != null ? stdNo.hashCode() : 0);
		result = 29 * result + (entranceDate != null ? entranceDate.hashCode() : 0);
		return result;
	}
}
