package com.intuit.journal.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Log record is the basic element in a log.
 * <p>
 * TODO: Need to implement clone , readExternal and writeExternal method.
 * Created by rsingh13
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "attribute",
        "clientID",
        "clientTimestamp",
        "op",
        "tid",
        "timestamp",
        "type",
        "userContext",
        "value"
})
public class LogRecord implements Serializable {


    /**
     * ID for an entity or relationship being changed
     * (Required)
     */
    @JsonProperty("id")
    @JsonPropertyDescription("name of the attribute being changed")
    private String id;

    /**
     * name of the attribute being changed
     * (Required)
     */
    @JsonProperty("attribute")
    @JsonPropertyDescription("name of the attribute being changed")
    private String attribute;
    /**
     * id of the client making  the changes
     * (Required)
     */
    @JsonProperty("clientID")
    @JsonPropertyDescription("id of the client making  the changes")
    private String clientID;
    /**
     * client timestamp , timestamp at which fact happened in client user space
     * (Required)
     */
    @JsonProperty("clientTimestamp")
    @JsonPropertyDescription("client timestamp , timestamp at which fact happened in client user space")
    private long clientTimestamp;
    /**
     * type of operation whether its insert update or delete
     * (Required)
     */
    @JsonProperty("op")
    @JsonPropertyDescription("type of operation whether its insert update or delete")
    private long op;
    /**
     * Id which uniquely identifies the current batch of mutations
     * (Required)
     */
    @JsonProperty("tid")
    @JsonPropertyDescription("Id which uniquely identifies the current batch of mutations")
    private String tid;
    /**
     * server side timestamp , when event arrived at DFPS server
     * (Required)
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("server side timestamp , when event arrived at DFPS server")
    private long timestamp;
    /**
     * Entity or Relationship (Are changes to entities or relationship) Value can be 0 or 1
     * (Required)
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Entity or Relationship (Are changes to entities or relationship) Value can be 0 or 1 ")
    private long type;
    /**
     * User Context information
     */
    @JsonProperty("userContext")
    @JsonPropertyDescription("User Context information ")
    private String userContext;
    /**
     * after change value of the attribute
     * (Required)
     */
    @JsonProperty("value")
    @JsonPropertyDescription("after change value of the attribute ")
    private String value;
    private final static long serialVersionUID = 5249569248355320625L;

    /**
     * No args constructor for use in serialization
     */
    public LogRecord() {
    }

    /**
     * @param timestamp
     * @param op
     * @param clientTimestamp
     * @param value
     * @param clientID
     * @param attribute
     * @param userContext
     * @param tid
     * @param type
     */
    public LogRecord(String id,String attribute, String clientID, long clientTimestamp, long op, String tid, long timestamp,
                     long type, String userContext, String value) {
        super();
        this.id = id;
        this.attribute = attribute;
        this.clientID = clientID;
        this.clientTimestamp = clientTimestamp;
        this.op = op;
        this.tid = tid;
        this.timestamp = timestamp;
        this.type = type;
        this.userContext = userContext;
        this.value = value;
    }

    /**
     * ID of the entity or relationship which is changed.
     * @return
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }


    /**
     * ID of the entity or relationship which is changed.
     * @return
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }


    /**
     * name of the attribute being changed
     * (Required)
     */
    @JsonProperty("attribute")
    public String getAttribute() {
        return attribute;
    }

    /**
     * name of the attribute being changed
     * (Required)
     */
    @JsonProperty("attribute")
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * id of the client making  the changes
     * (Required)
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * id of the client making  the changes
     * (Required)
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * client timestamp , timestamp at which fact happened in client user space
     * (Required)
     */
    @JsonProperty("clientTimestamp")
    public long getClientTimestamp() {
        return clientTimestamp;
    }

    /**
     * client timestamp , timestamp at which fact happened in client user space
     * (Required)
     */
    @JsonProperty("clientTimestamp")
    public void setClientTimestamp(long clientTimestamp) {
        this.clientTimestamp = clientTimestamp;
    }

    /**
     * type of operation whether its insert update or delete
     * (Required)
     */
    @JsonProperty("op")
    public long getOp() {
        return op;
    }

    /**
     * type of operation whether its insert update or delete
     * (Required)
     */
    @JsonProperty("op")
    public void setOp(long op) {
        this.op = op;
    }

    /**
     * Id which uniquely identifies the current batch of mutations
     * (Required)
     */
    @JsonProperty("tid")
    public String getTid() {
        return tid;
    }

    /**
     * Id which uniquely identifies the current batch of mutations
     * (Required)
     */
    @JsonProperty("tid")
    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * server side timestamp , when event arrived at DFPS server
     * (Required)
     */
    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * server side timestamp , when event arrived at DFPS server
     * (Required)
     */
    @JsonProperty("timestamp")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * Entity or Relationship (Are changes to entities or relationship) Value can be 0 or 1
     * (Required)
     */
    @JsonProperty("type")
    public long getType() {
        return type;
    }

    /**
     * Entity or Relationship (Are changes to entities or relationship) Value can be 0 or 1
     * (Required)
     */
    @JsonProperty("type")
    public void setType(long type) {
        this.type = type;
    }

    /**
     * User Context information
     */
    @JsonProperty("userContext")
    public String getUserContext() {
        return userContext;
    }

    /**
     * User Context information
     */
    @JsonProperty("userContext")
    public void setUserContext(String userContext) {
        this.userContext = userContext;
    }

    /**
     * after change value of the attribute
     * (Required)
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * after change value of the attribute
     * (Required)
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString( this );
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append( id )
                .append( attribute )
                .append( clientID )
                .append( clientTimestamp )
                .append( op ).append( tid )
                .append( timestamp )
                .append( type )
                .append( userContext )
                .append( value )
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LogRecord) == false) {
            return false;
        }
        LogRecord rhs = ((LogRecord) other);
        return new EqualsBuilder().append( id,rhs.id ).append( attribute, rhs.attribute ).
                append( clientID, rhs.clientID ).
                                          append( clientTimestamp, rhs.clientTimestamp ).
                                          append( op, rhs.op ).append( tid, rhs.tid ).
                                          append( timestamp, rhs.timestamp ).
                                          append( type, rhs.type ).
                                          append( userContext, rhs.userContext ).
                                          append( value, rhs.value ).
                                          isEquals();
    }

}

