package net.thomasmaestas.java.bean0;

public class UserAddress {
	private String msgHandle;
	private int userId;
 
	public UserAddress() {
		
	}
	public UserAddress(String msgHandle, int userId) {
//	super();
		this.msgHandle = msgHandle;
		this.userId = userId;
	}

	public void defaultInit() {
		System.out.println("#default-init bean created: " + this);
	}

	public void defaultDestroy() {
		System.out.println("#default-destroy -- Bean created: " + this);
	}

	
	
	
	public void setMsgHandle(String msgHandle) {
		this.msgHandle = msgHandle;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [msgHandle=" + msgHandle + ", userId=" + userId + "]";
	}
 

}
