package com.example.vaadin;

import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.argThat;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Application;
import com.example.dao.TeamDao;
import com.example.entity.Team;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TeamEditorTests {

    private static final String NAME = "Marcin";
    private static final Integer AGE = 14;

    @Mock TeamDao teamDao;
    @InjectMocks TeamEditor editor;

    @Test
    public void shouldStoreTeamInRepoWhenEditorSaveClicked() {
        this.editor.name.setValue(NAME);
        this.editor.age.setValue(AGE+"");
        customerDataWasFilled();

        this.editor.save.click();

        then(this.teamDao).should().save(argThat(testMatchesEditorFields()));
    }

    @Test
    public void shouldDeleteTeamFromRepoWhenEditorDeleteClicked() {
        this.editor.name.setValue(NAME);
        this.editor.age.setValue(AGE+"");
        customerDataWasFilled();

        editor.delete.click();

        then(this.teamDao).should().delete(argThat(testMatchesEditorFields()));
    }

    private void customerDataWasFilled() {
        this.editor.editTeam(new Team(NAME, AGE));
    }

    private TypeSafeMatcher<Team> testMatchesEditorFields() {
        return new TypeSafeMatcher<Team>() {
            @Override public void describeTo(Description description) {

            }

            @Override protected boolean matchesSafely(Team item) {
                return NAME.equals(item.getName()) && (AGE == item.getAge());
            }
        };
    }

}
