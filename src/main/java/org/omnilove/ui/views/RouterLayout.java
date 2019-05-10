package org.omnilove.ui.views;

import org.omnilove.ui.views.Main;
import com.github.appreciated.app.layout.behaviour.Behaviour;
import com.github.appreciated.app.layout.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.items.LeftClickableItem;
import com.github.appreciated.app.layout.component.menu.left.items.LeftNavigationItem;
import com.github.appreciated.app.layout.entity.DefaultBadgeHolder;
import com.github.appreciated.app.layout.notification.DefaultNotificationHolder;
import com.github.appreciated.app.layout.notification.component.AppBarNotificationButton;
import com.github.appreciated.app.layout.notification.entitiy.DefaultNotification;
import com.github.appreciated.app.layout.router.AppLayoutRouterLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.Push;

import static com.github.appreciated.app.layout.entity.Section.FOOTER;

@Push
public class RouterLayout extends AppLayoutRouterLayout {
	/**
	 * Do not initialize here. This will lead to NPEs
	 */
	private DefaultNotificationHolder notifications;
	private DefaultBadgeHolder badge;
	public RouterLayout() {
		notifications = new DefaultNotificationHolder(newStatus -> {
		});
		badge = new DefaultBadgeHolder(5);
		for (int i = 1; i < 6; i++) {
			notifications.addNotification(new DefaultNotification("Test title" + i, "A rather long test description ..............." + i));
		}
		LeftNavigationItem menuEntry = new LeftNavigationItem("Menu", VaadinIcon.MENU.create(), Main.class);
		badge.bind(menuEntry.getBadge());
		init(AppLayoutBuilder
				.get(Behaviour.LEFT_RESPONSIVE_HYBRID)
				.withTitle("omnilove")
				.withIcon(VaadinIcon.HEART.name())
				.withAppBar(AppBarBuilder.get()
						.add(new AppBarNotificationButton<>(VaadinIcon.BELL, notifications))
						.build())
				.withAppMenu(LeftAppMenuBuilder.get()
						.add(new LeftNavigationItem("Home", VaadinIcon.HOME.create(), Main.class))
						.add(LeftSubMenuBuilder.get("My Submenu", VaadinIcon.PLUS.create())
								.add(LeftSubMenuBuilder.get("My Submenu", VaadinIcon.PLUS.create())
										.build())

								.build())
						.add(menuEntry)
						.addToSection(new LeftClickableItem("Clickable Entry", VaadinIcon.COG.create(), clickEvent -> Notification.show("onClick ...")), FOOTER)
						.build())
				.build());
	}
}
