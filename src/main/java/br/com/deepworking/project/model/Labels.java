package br.com.deepworking.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.StringUtils;

@Embeddable
public class Labels implements Iterable<Label> {

    @OneToMany
    private Set<Label> labels = new HashSet<>();

    public void add(Label label) {
        labels.add(label);
    }

    @Override
    public Iterator<Label> iterator() {
        return labels.iterator();
    }

    public int size() {
        return labels.size();
    }

    @Override
    public String toString() {
        List<String> strLabels = new ArrayList<>();
        labels.forEach(label -> strLabels.add(label.getName()));
        return StringUtils.join(strLabels.toArray(new String[]{}), ",");
    }
}
