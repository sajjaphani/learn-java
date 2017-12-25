package org.learnjava.design.bookashow;

import java.util.Date;

/**
 * 
 * @author psajja
 *
 */
public class TimeSlot {
    private String id;
    
    private Date startTime;
    private Date endTime;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TimeSlot() {
    	
    }

	public Date getStartTime() {
		return new Date(startTime.getTime());
	}

	public void setStartTime(Date startTime) {
		this.startTime = new Date(startTime.getTime());
	}

	public Date getEndTime() {
		return new Date(endTime.getTime());
	}
      
	public void setEndTime(Date endTime) {
		this.endTime = new Date(endTime.getTime());
	}
}
