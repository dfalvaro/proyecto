 package com.proyecto.web.util;
 
 import javax.faces.component.UIComponent;
 import javax.faces.context.FacesContext;
 import javax.faces.convert.Converter;
 import javax.faces.convert.FacesConverter;
 
 @FacesConverter(forClass=String.class)
 public class StringTrimmer implements Converter
 {
public Object getAsObject(FacesContext context, UIComponent component, String value)
{
/* 13 */     return value != null ? value.trim() : null;
}

public String getAsString(FacesContext context, UIComponent component, Object value)
{
/* 18 */     return (String)value;
}
 }

