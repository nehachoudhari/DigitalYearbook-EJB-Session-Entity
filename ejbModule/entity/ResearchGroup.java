package entity;

import java.io.Serializable;


/**
 * @author nhchdhr
 * 
 * This class represents the Research Group entity and provides getters and setters for its fields
 * Student entity is mapped to ResearchGroup table in the database 
 *
 */
public class ResearchGroup implements Serializable{

	private int groupId;
	private String name;
	private String description;
}
