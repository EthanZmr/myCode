package cn.ethan.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_password;
	
	private Set<Role> setRole = new HashSet<Role>();
	
	public Set<Role> getSetRole() {
		return setRole;
	}
	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer user_id, String user_name, String user_password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password + "]";
	}
	
}
