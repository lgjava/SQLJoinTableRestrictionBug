package org.hibernate.bugs.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLJoinTableRestriction;

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
@Table(name = "clazz_inf")
@Getter
@Setter
@ToString
public class Clazz
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clazz_code")
	private Integer code;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Student.class)
	@JoinTable(
			name = "student_clazz",
			joinColumns = @JoinColumn(name = "clazz_code"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	@SQLJoinTableRestriction("active = true")
	@ToString.Exclude
	private Set<Student> students = new HashSet<>();
}