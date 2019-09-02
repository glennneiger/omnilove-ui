package org.omnilove.ui.views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "create-project", layout = RouterLayout.class)
public class CreateProject extends VerticalLayout {

	public CreateProject() {
		FormLayout form = new FormLayout();

		TextField name = new TextField("Project Name");
		TextField shortDesc = new TextField("Short Description");
		TextArea desc = new TextArea("Project Description");




		Label label = new Label("Welcome to omnilove");
		label.setWidthFull();
		add(label);
	}
}