package com.example.vaadin;

import static org.assertj.core.api.BDDAssertions.then;

import javax.annotation.PostConstruct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.TeamDao;
import com.example.entity.Team;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.boot.VaadinAutoConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VaadinUITests.Config.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class VaadinUITests {

    @Autowired TeamDao teamDao;
    
    VaadinRequest vaadinRequest = Mockito.mock(VaadinRequest.class);
    TeamEditor editor;
    VaadinUI vaadinUI;

    @Before
    public void setup() {
        this.editor = new TeamEditor(this.teamDao);
        this.vaadinUI = new VaadinUI(this.teamDao, editor);
    }

    @Test
    public void shouldInitializeTheGridWithTeamDaoData() {
        int teamCount = (int) this.teamDao.count();

        vaadinUI.init(this.vaadinRequest);

        then(vaadinUI.grid.getColumns()).hasSize(3);
        then(vaadinUI.grid.getContainerDataSource().getItemIds()).hasSize(teamCount);
    }

    @Test
    public void shouldFillOutTheGridWithNewData() {
        int initialTeamCount = (int) this.teamDao.count();
        this.vaadinUI.init(this.vaadinRequest);
        teamDataWasFilled(editor, "Marcin", 99);

        this.editor.save.click();

        then(vaadinUI.grid.getContainerDataSource().getItemIds()).hasSize(initialTeamCount + 1);
        then((Team) vaadinUI.grid.getContainerDataSource().lastItemId())
                .extracting("firstName", "age")
                .containsExactly("Marcin", "Grzejszczak");
    }

    @Test
    public void shouldFilterOutTheGridWithTheProvidedLastName() {
        this.vaadinUI.init(this.vaadinRequest);
        this.teamDao.save(new Team("Josh", 99));

        vaadinUI.listTeams("Long");

        then(vaadinUI.grid.getContainerDataSource().getItemIds()).hasSize(1);
        then((Team) vaadinUI.grid.getContainerDataSource().lastItemId())
                .extracting("firstName", "lastName")
                .containsExactly("Josh", "Long");
    }

    @Test
    public void shouldInitializeWithInvisibleEditor() {
        this.vaadinUI.init(this.vaadinRequest);

        then(this.editor.isVisible()).isFalse();
    }

    @Test
    public void shouldMakeEditorVisible() {
        this.vaadinUI.init(this.vaadinRequest);
        Object itemId = this.vaadinUI.grid.getContainerDataSource().getItemIds().iterator().next();

        this.vaadinUI.grid.select(itemId);

        then(this.editor.isVisible()).isTrue();
    }

    private void teamDataWasFilled(TeamEditor editor, String name, Integer age) {
        this.editor.name.setValue(name);
        this.editor.age.setValue(age+"");
        editor.editTeam(new Team(name, age));
    }

    @Configuration
    @EnableAutoConfiguration(exclude = VaadinAutoConfiguration.class)
    static class Config {

        @Autowired TeamDao teamDao;

        @PostConstruct
        public void initializeData() {
            this.teamDao.save(new Team("Jack", 99));
            this.teamDao.save(new Team("Chloe", 88));
            this.teamDao.save(new Team("Kim", 33));
            this.teamDao.save(new Team("David", 44));
            this.teamDao.save(new Team("Michelle", 55));
        }

    }

}
