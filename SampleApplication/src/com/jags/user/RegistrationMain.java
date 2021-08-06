package com.jags.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class RegistrationMain {
	public static void main(String[] arg) {
		
		List<Registration> regList = Arrays.asList(new Registration("9003213933", new Date("11/31/2021")),
				new Registration("9003213933", new Date("11/31/2021")),
				new Registration("9003212399", new Date("11/31/2021")),
				new Registration("8003213933", new Date("11/31/2021")),
				new Registration("7003213933", new Date("11/31/2021")),
				new Registration("8003213933", new Date("11/31/2021")),
				new Registration("0003213933", new Date("11/31/2021")),
				new Registration("9003213933", new Date("11/31/2021")));
		
		List<User> userList = Arrays.asList(new User("User1", 50),
				new User("User1", 50),
				new User("User1", 60),
				new User("User1", 80),
				new User("User1", 50),
				new User("User1", 90),
				new User("User1", 50));
		
		System.out.println("Before::");
		System.out.println(regList);
		Comparator<Registration> registrationComparator = (Registration r1, Registration r2) -> {
			String num2 = r2.getRegisteredMobileNumber();
			List<User> userList1 = r1.getUserList();
			
			userList1.stream().map(user -> user.getAge()).forEach(age -> {
				System.out.println(age);
			});;
			
			
			List<User> userList2 = r2.getUserList();
			
			
			
			return r1.getRegisteredMobileNumber().compareTo(num2);
		};
		Collections.sort(regList, registrationComparator);
		System.out.println(regList);
		
		//System.out.println(new Date("11/31/2021"));
	}

}
