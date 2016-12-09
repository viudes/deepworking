package br.com.deepworking.project.web.view;

import java.util.Collection;
import java.util.Iterator;

import br.com.deepworking.project.model.Activity;

public class ActivitiesViewPresenter implements Iterable<ActivityViewPresenter> {

    private Collection<Activity> activities;

    public ActivitiesViewPresenter(Collection<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public Iterator<ActivityViewPresenter> iterator() {
        return new ActivityViewPresenterIterator(activities.iterator());
    }

    private class ActivityViewPresenterIterator implements Iterator<ActivityViewPresenter> {
        private Iterator<Activity> iterator;

        public ActivityViewPresenterIterator(Iterator<Activity> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public ActivityViewPresenter next() {
            return new ActivityViewPresenter(iterator.next());
        }

    }
}
