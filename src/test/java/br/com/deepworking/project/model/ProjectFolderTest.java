package br.com.deepworking.project.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.deepworking.project.model.exception.ResourceNotFoundException;
import br.com.deepworking.project.model.repository.ProjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProjectFolderTest {

    @Mock
    private ProjectRepository projectRepository;

    private ProjectFolder projectFolder;

    private int projectId = 1;

    @Before
    public void setUp() {
        projectFolder = new ProjectFolder();
        projectFolder.setProjectRepository(projectRepository);
    }

    @Test
    public void shouldFindProjectByIdAndPresentItsName() {

        when(projectRepository.findById(projectId)).thenReturn(getExistentProject());

        Project projectFound = projectFolder.findProjectById(projectId).get();

        assertEquals("project a", projectFound.getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void shouldReturnNullProjectWhenThereIsNoProjectById() {
        when(projectRepository.findById(projectId)).thenReturn(null);

        projectFolder.findProjectById(projectId).get();
    }

    private Project getExistentProject() {
        Project project = new Project("project a");
        return project;
    }

}
