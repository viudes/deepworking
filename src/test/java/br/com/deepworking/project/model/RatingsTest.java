package br.com.deepworking.project.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.deepworking.project.model.exception.InvalidActivityRatingException;
import br.com.deepworking.project.model.repository.ActivityRepository;

@RunWith(MockitoJUnitRunner.class)
public class RatingsTest {

    private Integer activityId = 1;

    @Mock
    private ActivityRepository activityRepository;

    private Ratings ratings;

    @Before
    public void setUp() {
        ratings = new Ratings();
        ratings.setActivityRepository(activityRepository);
    }

    @Test
    public void shouldFindActivityRatingForRatingPurposes() {
        Mockito.when(activityRepository.findOne(activityId)).thenReturn(getValidActivity());
        ActivityRating activityRatingFound = ratings.findActivityBy(activityId);

        assertNotNull(activityRatingFound);
    }

    @Test(expected = InvalidActivityRatingException.class)
    public void shouldThrowResourceNotFoundWhenActivityNotFound() {
        Mockito.when(activityRepository.findOne(activityId)).thenReturn(null);

        ratings.findActivityBy(activityId);
    }

    private Activity getValidActivity() {
        return new Activity();
    }

}
