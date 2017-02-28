package com.example.vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.dao.TeamDao;
import com.example.entity.Team;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

	private final TeamDao dao;

	private final TeamEditor editor;

	final Grid grid;

	final TextField filter;

	private final Button addNewBtn;

	@Autowired
	public VaadinUI(TeamDao dao, TeamEditor editor) {
		this.dao = dao;
		this.editor = editor;
		this.grid = new Grid();
		this.filter = new TextField();
		this.addNewBtn = new Button("New customer", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		// Configure layouts and components
		actions.setSpacing(true);
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "name", "age");

		filter.setInputPrompt("Filter by last name");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.addTextChangeListener(e -> listTeams(e.getText()));

		// Connect selected Team to editor or hide if none is selected
		grid.addSelectionListener(e -> {
			if (e.getSelected().isEmpty()) {
				editor.setVisible(false);
			}
			else {
				editor.editTeam((Team) grid.getSelectedRow());
			}
		});

		// Instantiate and edit new Team the new button is clicked
		addNewBtn.addClickListener(e -> editor.editTeam(new Team("", null)));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listTeams(filter.getValue());
		});

		// Initialize listing
		listTeams(null);
	}

	// tag::listTeams[]
	void listTeams(String text) {
		if (StringUtils.isEmpty(text)) {
			grid.setContainerDataSource(new BeanItemContainer(Team.class, dao.findAll()));
		}else {
			grid.setContainerDataSource(new BeanItemContainer(Team.class, dao.findByNameStartsWithIgnoreCase(text)));
		}
	}
	// end::listTeams[]

}
