package org.omnilove.ui.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = RouterLayout.class)
public class Main extends VerticalLayout {
	public Main() {
		Label label = new Label("Welcome to omnilove");
label.setWidthFull();
add(label);
	}
}