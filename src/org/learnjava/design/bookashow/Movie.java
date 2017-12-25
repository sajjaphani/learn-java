package org.learnjava.design.bookashow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author psajja
 *
 */
public class Movie {

    private Integer id;
    
    private String title;
    
    private List<String> actors;

    public Movie() {
    	actors = new ArrayList<>();
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addActor(String actor) {
		actors.add(actor);
	}
}
