package org.omnilove.ui.views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "projects", layout = RouterLayout.class)
public class Projects extends VerticalLayout {

	public Projects() {
		Label label = new Label("All ");
		label.setWidthFull();
		add(label);
	}
}