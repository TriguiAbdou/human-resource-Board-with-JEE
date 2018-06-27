package tn.esprit.b3.esprit1718b3hrboard.entities;

public class UserConnected {
	private static User userConnected;

	public static User getUserConnected() {
		return userConnected;
	}

	public static void setUserConnected(User userConnected) {
		UserConnected.userConnected = userConnected;
	}
	
	

}
