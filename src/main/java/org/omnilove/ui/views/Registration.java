package org.omnilove.ui.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.omnilove.ui.dto.User;

@Route(value = "register")
public class Registration extends VerticalLayout {
	private FormLayout regForm = new FormLayout();
	private TextField username = new TextField("Username");
	private TextField firstname = new TextField("First Name");
	private TextField surname = new TextField("Surname");
	private EmailField email = new EmailField("Email Address");
	private DatePicker birthday = new DatePicker("Birthday");
	private PasswordField password = new PasswordField("Password");
	private Button submit = new Button("Submit");
	Binder<User> binder = new Binder<>(User.class);

	public Registration(){
		regForm.add(username,firstname,surname,email,birthday,password,submit);
		regForm.setMaxWidth("500px");
		regForm.setClassName("center");
		add(regForm);

		// Start by defining the Field instance to use
		binder.forField(username).bind(User::getUsername, User::setUsername);
		binder.forField(firstname).bind(User::getFirstname, User::setUsername);
		binder.forField(surname).bind(User::getSurname, User::setSurname);
		binder.forField(email).bind(User::getEmail, User::setUsername);
		//todo add converter
		//binder.forField(birthday).bind(User::getBirthday, User::setBirthday);
		binder.forField(password).bind(User::getPassword, User::setPassword);

		submit.setDisableOnClick(true);
		submit.addClickListener( event -> {
			try {
				User user = new User();
				binder.writeBean(user);
				//todosave the user
			} catch (ValidationException e) {
				Notification noti = new Notification();
				noti.show("something went wrong, please try again or let us know.", 2, Notification.Position.TOP_CENTER);

			}
		});

	}
}
