package tp.basic.link.acl;

//@Getter @Setter @NoArgsConstructor
public class MyResource {
	private String name;
	private AbstractACL acl; //firt node/cell of linked list
	
	boolean isAuthorizedForUser(MyUser user) {
		if(acl==null)
			return false;
		Boolean auth = acl.isAuthorizedForUser(user);
		if(auth==null)
			return false;
		else
			return auth.booleanValue();
	}
	
	void aclAdd(AbstractACL control) {
		if(acl==null) {
			acl=control;
		}else {
			control.setNextLink(acl);
			acl=control;//new first control in linked cell/node
		}
	}


	public MyResource(String name, AbstractACL acl) {
		super();
		this.name = name;
		this.acl = acl;
	}
	
	public MyResource(String name) {
		this(name,null);
	}
	
	public MyResource() {
		this(null,null);
	}

	@Override
	public String toString() {
		return "MyResource [name=" + name + ", acl=" + acl + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractACL getAcl() {
		return acl;
	}

	public void setAcl(AbstractACL acl) {
		this.acl = acl;
	}
	
	
	
	
}
