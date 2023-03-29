package com.aixtor.portal.color.preference;

/**
 * @author Urva Patel
 */
import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.aixtor.portal.color.preference.ColorConfiguration")
public interface ColorConfiguration {
	
    @Meta.AD(
        name = "color", 
        optionLabels = { "%White", "%Red", "%Yellow" }, 
        optionValues = { "white", "red", "yellow" }, 
        required = false
    )
 
    public String color();
}
