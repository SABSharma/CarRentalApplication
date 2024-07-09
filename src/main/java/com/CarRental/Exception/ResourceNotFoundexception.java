package com.CarRental.Exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundexception extends  RuntimeException {

    private  String description;
    private  String resourceName;
    private  String fieldName;


    public  ResourceNotFoundexception( String description, String resourceName,String  fieldName){
        super(String.format("%s %s : %s" , description, resourceName , fieldName ));
        this.description=description;
        this.resourceName=resourceName;
        this.fieldName=fieldName;

    }


}
