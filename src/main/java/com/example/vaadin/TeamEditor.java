package com.example.vaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.TeamDao;
import com.example.entity.Team;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class TeamEditor extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	private final TeamDao dao;

	/**
	 * The currently edited team
	 */
	private Team team;

	/* Fields to edit properties in Team entity */
	TextField name = new TextField("name");
	TextField age = new TextField("Age");

	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	@Autowired
	public TeamEditor(TeamDao dao) {
		this.dao = dao;

		addComponents(name, age, actions);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> dao.save(team));
		delete.addClickListener(e -> dao.delete(team));
		cancel.addClickListener(e -> editTeam(team));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editTeam(Team c) {
		final boolean persisted = (c.getId() != null);
		if (persisted) {
			team = dao.findOne(c.getId());
		}else {
			team = c;
		}
		cancel.setVisible(persisted);

		BeanFieldGroup.bindFieldsUnbuffered(team, this);

		setVisible(true);

		save.focus();
		name.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}
}
