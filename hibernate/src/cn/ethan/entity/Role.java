package cn.ethan.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer role_id;
	private String role_name;
	private String role_memo;
	
	private Set<User> setUser = new HashSet<User>();
	
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Integer role_id, String role_name, String role_memo) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_memo = role_memo;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_memo() {
		return role_memo;
	}
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result + ((role_memo == null) ? 0 : role_memo.hashCode());
		result = prime * result + ((role_name == null) ? 0 : role_name.hashCode());
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
		Role other = (Role) obj;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (role_memo == null) {
			if (other.role_memo != null)
				return false;
		} else if (!role_memo.equals(other.role_memo))
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_memo=" + role_memo + "]";
	}
	
	
}
