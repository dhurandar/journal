package com.intuit.journal;

import com.google.common.base.Preconditions;
import com.intuit.journal.util.UUIDs;

import java.util.UUID;

/**
 * Created by rsingh13
 */
public class Token {

    private UUID id  = null;


    private Token() {
        id = UUIDs.timeBased();

    }

    private Token(UUID id) {
        this.id = id;
    }

    public static final Token getTimeBased() {
        return new Token();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Preconditions.checkNotNull( obj );
        if (obj == this) {
            return true;
        }
        if ((obj instanceof UUID) == false) {
            return false;
        }
        return obj.equals( id );

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //TODO implement deep copy
        Token newId = new Token(this.id);
        return newId;
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
