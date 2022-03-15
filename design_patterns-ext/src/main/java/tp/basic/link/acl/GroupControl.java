package tp.basic.link.acl;

import tp.basic.link.acl.AbstractACL.GrantType;

public class GroupControl extends AbstractACL {
	private String groupname;
	
	public GroupControl(String groupname,GrantType grantType) {
		super(grantType);
		this.groupname = groupname;
	}
	
	public GroupControl(String groupname) {
		super();
		this.groupname = groupname;
	}

	private Boolean isGroupNameAuthorized(MyUser u) {
		if(u.getGroupnames().contains(this.groupname) 
		    && this.getGrantType()==GrantType.AUTHORIZED) 
             return true;
		else return null;
	}
	
	private boolean isGroupNameDeny(MyUser u) {
		if(u.getGroupnames().contains(this.groupname) 
		    && this.getGrantType()==GrantType.DENY) 
             return true;
		else return false;
	}
	
	@Override
	public Boolean isAuthorizedForUser(MyUser user) {
		if(isGroupNameDeny(user))
			return false;//no need to test remain acl 
		else
		   return logicalAuthorization(isGroupNameAuthorized(user),
				                    this.isAuthorizedForUserInRemainAcl(user));
	}
}
