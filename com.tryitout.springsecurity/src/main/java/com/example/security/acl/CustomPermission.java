package com.example.security.acl;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.model.Permission;

public class CustomPermission extends BasePermission {

	protected CustomPermission(int mask, char code) {
		super(mask, code);
		System.out.println("** CustomPermission** " + mask + ", " + code);
	}

	protected CustomPermission(int mask) {
		super(mask);
		System.out.println("** CustomPermission** " + mask);
	}

	private static final long serialVersionUID = 2103747555879390796L;
	 
	public static final Permission ADMIN_READ = new CustomPermission(1 << 5, 'M'); // 32

}
