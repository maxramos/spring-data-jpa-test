package com.maxaramos.samplespringdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

	public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

	private static final long serialVersionUID = 9215741738738381538L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "authority")
	private String authority;

	public Authority() {
		super();
	}

	public Authority(String authority) {
		this.authority = authority;
	}

	public Authority(GrantedAuthority grantedAuthority) {
		authority = grantedAuthority.getAuthority();
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (authority == null ? 0 : authority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Authority other = (Authority) obj;
		if (authority == null) {
			if (other.authority != null) {
				return false;
			}
		} else if (!authority.equals(other.authority)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Authority [id=%s, authority=%s]", id, authority);
	}

}
