package org.omnilove.ui.views;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.omnilove.ui.clients.UserClient;
import org.omnilove.ui.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

@StyleSheet("registration.css")
@Route(value = "registration")
public class Registration extends VerticalLayout {
	private Label welcomeLabel = new Label("Welcome to Omnilove, please join us");
	private FormLayout regForm = new FormLayout();
	private TextField username = new TextField("Username");
	private TextField firstname = new TextField("First Name");
	private TextField surname = new TextField("Surname");
	private EmailField email = new EmailField("Email Address");
	private DatePicker birthday = new DatePicker("Birthday");
	private PasswordField password = new PasswordField("Password");
	private Button submit = new Button("Submit");
	Binder<User> binder = new Binder<>(User.class);


	@Autowired
	UserClient client;

	public Registration(){
		regForm.add(username,firstname,surname,email,birthday,password,submit);
		setClassName("omnia-center");
		setMaxWidth("500px");
		welcomeLabel.setClassName("omnia-center");
		welcomeLabel.setClassName("marign-top-10");
		add(welcomeLabel);
		add(regForm);

		// Start by defining the Field instance to use
		binder.forField(username).bind(User::getUsername, User::setUsername);
		binder.forField(firstname).bind(User::getFirstname, User::setFirstname);
		binder.forField(surname).bind(User::getSurname, User::setSurname);
		binder.forField(email).bind(User::getEmail, User::setEmail);
		binder.forField(birthday).bind(User::getBirthday, User::setBirthday);
		binder.forField(password).bind(User::getPassword, User::setPassword);

	//	submit.setDisableOnClick(true);
		submit.addClickListener( event -> {
			try {
				User user = new User();
				binder.writeBean(user);
				HttpResponse response = client.registerUser(user.getUsername(),user.getFirstname(), user.getSurname(), user.getMotivation(), user.getEmail(), user.getBirthday());
			} catch (ValidationException e) {
				Notification noti = new Notification();
				noti.show("something went wrong, please try again or let us know.", 2, Notification.Position.TOP_CENTER);

			}
		});

	}
}
