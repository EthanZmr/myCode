package com.ethan.web;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionActivationListener{
	
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("我和session钝化了");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		System.out.println("我和session活化了");
	}

}
