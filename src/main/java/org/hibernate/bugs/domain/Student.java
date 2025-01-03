package org.hibernate.bugs.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2024, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 *
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
@Entity
@Table(name = "student_inf")
public class Student
{
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;
	private int age;
	private char gender;
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Clazz.class)
	@JoinTable(
			name = "student_clazz",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "clazz_code")
	)
	private Set<Clazz> clazzes = new HashSet<>();

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}

	public char getGender()
	{
		return gender;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public Set<Clazz> getClazzes()
	{
		return clazzes;
	}
	public void setClazzes(Set<Clazz> clazzes)
	{
		this.clazzes = clazzes;
	}

	@Override
	public String toString()
	{
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", age=" + age +
				", gender=" + gender +
				'}';
	}
}
