package com.Immob.Entites.DAOs.JdbcTemplates.Mappers.UIs.Tools;

public class TypeImmobilier {

    public enum Type {
	MAISON, APPARTEMENT
    }

    public Type toTypeImmobilier(String typeString) {
	for (Type type : TypeImmobilier.Type.values()) {
	    if (type.toString().equalsIgnoreCase(typeString.trim())) {
		return type;
	    }
	}
	return null;
    }
}
