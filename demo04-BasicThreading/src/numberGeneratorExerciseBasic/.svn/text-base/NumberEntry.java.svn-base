/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading
 */
package numberGeneratorExerciseBasic;

/**
 * NumberEntry.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: Represents a number entry by the value it was assigned
 * and the thread that created the value assigned to it.
 */
public class NumberEntry
{
	//Attributes
	private int 			value;
	private String 			createdBy;
	
	//Contructor
	/**
	 * User defined values assigned to class level attributes.
	 * @param value the number assigned to this entry
	 * @param createdBy the name of the thread that generated the number
	 */
	public NumberEntry(int value, String createdBy)
	{
		this.value = value;
		this.createdBy = createdBy;
	}
	
	//Getters and Setters
	/**
	 * @return Returns the createdBy.
	 */
	public String getCreatedBy()
	{
		return createdBy;
	}

	/**
	 * @param createdBy The createdBy to set.
	 */
	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	/**
	 * @return Returns the value.
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	//Operational Methods
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return createdBy+" "+value;
	}
}
