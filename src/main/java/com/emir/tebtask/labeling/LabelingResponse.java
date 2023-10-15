package com.emir.tebtask.labeling;

import java.util.List;

public class LabelingResponse {
    List<String> labels;
    List<Float> scores;
    String sequence;

    public LabelingResponse(List<String> labels, List<Float> scores, String sequence) {
        this.labels = labels;
        this.scores = scores;
        this.sequence = sequence;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Float> getScores() {
        return scores;
    }

    public void setScores(List<Float> scores) {
        this.scores = scores;
    }

    public String getSequence() {
        return sequence;
    }

    public LabelingResponse() {
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "LabelingResponse{" +
                "labels=" + labels +
                ", scores=" + scores +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
