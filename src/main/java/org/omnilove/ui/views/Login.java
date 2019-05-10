//package org.omnilove.ui.views;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.login.LoginForm;
//
//public class Login {
//
//	LoginForm component = new LoginForm();
//component.addLoginListener(e -> {
//		boolean isAuthenticated = authenticate(e);
//		if (isAuthenticated) {
//			navigateToMainPage();
//		} else {
//			component.setError(true);
//		}
//	})