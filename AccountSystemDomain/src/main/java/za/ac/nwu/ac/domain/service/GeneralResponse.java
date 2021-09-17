package za.ac.nwu.ac.domain.service;

import sun.java2d.loops.DrawGlyphListAA;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable {

    private final boolean succesful;
    private final transient  T payload;

    public GeneralResponse(boolean succesful, T payload)
    {
        this.succesful = succesful;
        this.payload = payload;
    }

    public boolean isSuccesful() {return succesful;}

    public T getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return succesful == that.succesful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {return Objects.hash(succesful, payload);}

    @Override
    public String toString()
    {
        return "GeneralResponse{" +
                "succesgul= " + succesful +
                ", payload= " + payload +
                '}';
    }
}
