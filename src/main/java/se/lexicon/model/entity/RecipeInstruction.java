package se.lexicon.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import static se.lexicon.model.constant.EntityConstants.GENERATOR;
import static se.lexicon.model.constant.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name =GENERATOR,strategy = UUID_GENERATOR)
    private String instrcutionID;
    private String instractions;

    protected RecipeInstruction() {
    }

    public RecipeInstruction(String instrcutionID, String instractions) {
        this.instrcutionID = instrcutionID;
        this.instractions = instractions;
    }

    public String getInstrcutionID() {
        return instrcutionID;
    }

    public void setInstrcutionID(String instrcutionID) {
        this.instrcutionID = instrcutionID;
    }

    public String getInstractions() {
        return instractions;
    }

    public void setInstractions(String instractions) {
        this.instractions = instractions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instrcutionID, that.instrcutionID) && Objects.equals(instractions, that.instractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrcutionID, instractions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instrcutionID='" + instrcutionID + '\'' +
                ", instractions='" + instractions + '\'' +
                '}';
    }
}
