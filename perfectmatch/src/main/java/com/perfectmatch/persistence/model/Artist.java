package com.perfectmatch.persistence.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All details about the artist ")
public class Artist implements NameableEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5955358399261452115L;

	@Id
    private String id;
    
	@ApiModelProperty(notes="Name of the artist - without format contrains")
	private String name;
	
	@ApiModelProperty(notes="Websites of the artist - without format contrains")
	private List<String> websites = new ArrayList<>();
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	
	public List<String> getWebsites() {
		return websites;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Artist other = (Artist) obj;
       
        return Objects.equals(id, other.id) && 
        		Objects.equals(name, other.name);
	}

	
	
}