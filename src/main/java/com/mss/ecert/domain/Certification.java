package com.mss.ecert.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Certification extends Auditable<String>{

	@Id
	@Column(name = "certificationid")
	private String certificationid;
	@Column(name = "certificationname")
	private String certificationname;
	@Column(name = "ismandatory")
	private boolean ismandatory;
	@Column(name = "certificationdescription")
	private String certificationdescription;
	@Column(name = "certificationnotice")
	private String certificationnotice;
	@Column(name = "certificationtime")
	private int certificationtime;

	@ElementCollection
    @CollectionTable(name = "assigned", joinColumns = @JoinColumn(name = "FK_assigned_certification"))
    @Column(name = "assigned")
    private List<String> assigned;
	@ElementCollection
    @CollectionTable(name = "assigned", joinColumns = @JoinColumn(name = "FK_quiztaken_certification"))
    @Column(name = "quiztaken")
    private List<String> quiztaken;
}
