package tp.basic.link.acl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyUser {
	private String username;
	private Set<String> groupnames;
		
	public MyUser(String username, Set<String> groupnames) {
		super();
		this.username = username;
		this.groupnames = groupnames;
	}
	
	public MyUser(String username) {
		this(username,new HashSet<>());
	}
	
	public MyUser() {
		this(null,new HashSet<>());
	}
	
	public MyUser(String username,String mainGroupname) {
		this(username,new HashSet<>());
		this.groupnames.add(mainGroupname);
	}
	
	public void addGroupName(String groupname) {
		this.groupnames.add(groupname);
	}
	
	public boolean hasGroupName(String groupname) {
		return this.groupnames.contains(groupname);
	}
	
	@Override
	public String toString() {
		return "MyUser [username=" + username + ", groupnames=" + groupnames + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<String> getGroupnames() {
		return groupnames;
	}
	public void setGroupnames(Set<String> groupnames) {
		this.groupnames = groupnames;
	}

	
}
