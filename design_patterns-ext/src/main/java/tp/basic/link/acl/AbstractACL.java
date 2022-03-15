package tp.basic.link.acl;

import tp.basic.link.AbstractLink;

public abstract class AbstractACL extends AbstractLink {
   public enum GrantType { DENY , AUTHORIZED };
   //public enum AccessType { CREATE , READ , UPDATE , DELETE };
   protected GrantType grantType;
   
   
   public AbstractACL(GrantType grantType) {
	   this.grantType = grantType;
   }
   
   public AbstractACL() {
	   this(GrantType.AUTHORIZED);//by default
   }


    public abstract Boolean isAuthorizedForUser(MyUser user); //true, false or null(?)
    
    public static Boolean logicalAuthorization(Boolean auth1,Boolean auth2) {
    	if(auth1==null && auth2==null)
    		  return null;
    	if(auth1==null)
    		 return auth2;
    	if(auth2==null)
    		 return auth1;
    	if(auth1==false || auth2==false) 
   	         return false;
    	return auth2 && auth1;
    }
  
	public Boolean isAuthorizedForUserInRemainAcl(MyUser user) {
		AbstractACL remainAcl = (AbstractACL) this.nextLink; //inherited from AbstractLink
		return (remainAcl==null)?null:remainAcl.isAuthorizedForUser(user);
	}
   
   
	public GrantType getGrantType() {
		return grantType;
	}
	public void setGrantType(GrantType grantType) {
		this.grantType = grantType;
	}
   
   
}
