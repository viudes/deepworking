package br.com.deepworking.project.web.converter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import br.com.deepworking.project.model.Project;
import br.com.deepworking.project.model.factory.ProjectFactory;
import br.com.deepworking.project.model.transfer.ProjectEntry;
import br.com.deepworking.project.model.transfer.ProjectEntry.ActivityTypeEntry;

public class ProjectEntryToProjectConverterTest {

    @Test
    public void shouldConvertFromProjectEntryToProject() {
        ProjectFactory converter = new ProjectFactory();

        ProjectEntry source = createProjectEntryAsSource();
        Project project = converter.createFrom(source);

        assertEquals(source.getName(), project.getName());
        assertEquals(source.getActivityTypes().size(), project.getActivityTypes().size());
    }

    private ProjectEntry createProjectEntryAsSource() {
        ProjectEntry source = new ProjectEntry();
        source.setName("Writing book");

        ActivityTypeEntry firstType = new ActivityTypeEntry();
        firstType.setName("study");
        firstType.setDescription("study the subject about to be written");

        ActivityTypeEntry secondType = new ActivityTypeEntry();
        secondType.setName("structure");
        secondType.setDescription("define the structures as chapters and topics");

        source.setActivityTypes(Arrays.asList(firstType, secondType));
        return source;
    }

}
