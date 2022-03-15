package tp.basic.link.acl;

import tp.basic.link.acl.AbstractACL.GrantType;

public class UserControl extends AbstractACL {
	private String username;
	
	public UserControl(String username,GrantType grantType) {
		super(grantType);
		this.username = username;
	}
	
	public UserControl(String username) {
		super();
		this.username = username;
	}
	
	private Boolean isUserNameAuthorized(MyUser u) {
		if(u.getUsername().equals(username)	&& this.getGrantType()==GrantType.AUTHORIZED) 
             return true;
		else return null;
	}
	
	private boolean isUserNameDeny(MyUser u) {
		if(u.getUsername().equals(username) && this.getGrantType()==GrantType.DENY) 
             return true;
		else return false;
	}
	
	@Override
	public Boolean isAuthorizedForUser(MyUser user) {
		if(isUserNameDeny(user))
			return false;//no need to test remain acl 
		else
		   return logicalAuthorization(isUserNameAuthorized(user),
				                    this.isAuthorizedForUserInRemainAcl(user));
	}
	
}
