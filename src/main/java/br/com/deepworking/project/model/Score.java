package br.com.deepworking.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Score {

    @Id
    @SequenceGenerator(name = "scoreSeq", sequenceName = "score_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scoreSeq")
    private Integer id;

    private ScorePoint points;

    private int interruptions;

    private String notes;

    @OneToOne
    private Activity activity;

    public Integer getId() {
        return id;
    }

    public ScorePoint getPoints() {
        return points;
    }

    public void setPoints(ScorePoint points) {
        this.points = points;
    }

    public int getInterruptions() {
        return interruptions;
    }

    public void setInterruptions(int interruptions) {
        this.interruptions = interruptions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Score [id=" + id + ", points=" + points + ", interruptions=" + interruptions + ", notes=" + notes
                + ", activity=" + activity + "]";
    }

}
