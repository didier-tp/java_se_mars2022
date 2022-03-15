package tp.basic.link.acl;

import java.util.ArrayList;
import java.util.List;

import tp.basic.link.acl.AbstractACL.GrantType;

public class TestAclApp {

	public static void main(String[] args) {
		testAcl();
	}
	
	public static void testAcl(){
		MyUser u1= new MyUser("u1","user");
		u1.addGroupName("admin");
		
		MyUser u2= new MyUser("u2","user");
		u2.addGroupName("publisher");
		
		MyUser u3= new MyUser("u3","guest");
		
		List<MyUser> userList = new ArrayList<>();
		userList.add(u1);userList.add(u2);userList.add(u3);
		
		MyResource r1 = new MyResource("r1");
		r1.aclAdd( new UserControl("u1"));//GrantType.AUTHORIZED by default
		r1.aclAdd( new UserControl("u2",GrantType.DENY));
		r1.aclAdd( new GroupControl("admin"));
		r1.aclAdd( new GroupControl("guest",GrantType.DENY));
		
		MyResource r2 = new MyResource("r2");
		r2.aclAdd( new UserControl("u1"));
		//r2.aclAdd( new UserControl("u2",GrantType.DENY));
		r2.aclAdd( new GroupControl("publisher"));
		
		MyResource r3 = new MyResource("r3");
		r3.aclAdd( new GroupControl("admin"));
		//r3.aclAdd( new GroupControl("guest"));
		r3.aclAdd( new GroupControl("user"));
		r3.aclAdd( new GroupControl("publisher"));
		
		List<MyResource> resourceList = new ArrayList<>();
		resourceList.add(r1);resourceList.add(r2);resourceList.add(r3);
		
		for(MyResource r : resourceList) {
			for(MyUser u : userList) {
				if(r.isAuthorizedForUser(u)) {
					System.out.println(r.getName() +" authorized for " + u);
				}else {
					System.out.println(r.getName() +" not authorized for " + u);
				}
			}
		}
		
	}

}
