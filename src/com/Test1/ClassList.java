package com.Test1;

import java.util.Arrays;

public class ClassList {
    private String teacherName;
    private String[] names;
    private int qtyNames;

    
	public ClassList(String teacherName) {
		teacherName= "";
		names = new String[5];
		qtyNames = 0;
		
//		
//		try {
//			ClassList cl = new ClassList ();
//			
//	        cl.addStudentName("Rohit");
//			cl.addStudentName("Atul");		
//			cl.addStudentName("Arshad");
//			cl.addStudentName("Rahul");
//			cl.addStudentName("Mohit");
//			
//        }catch(Exception e) {
//        	e.printStackTrace();
//        }
      
    }
    
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getQtyNames() {
        return qtyNames;
    }

    public void addStudentName(String name) throws DuplicateDataException {
		if(contains(name)){
			System.out.println("Duplicate name found");
			throw new DuplicateDataException("Duplicate name found");  //check 
		}else{
			names[qtyNames++] = name;
		}
    }
    
    public boolean contains(String name) {
		for(String nm : names){
			if(name.equalsIgnoreCase(nm)){
				return true;
			}
		}
		return false;
	}
    
    public void remove (int position) throws ArrayIndexOutOfBoundsException{
        String s = names[position]; //auto throw ArrayIndexOutOfBoundsException
		int curPosition = 0;
		for(String nm : names){
			if(curPosition < position){
				continue;
			}
			else if(curPosition != position){
				names[curPosition] = names[curPosition+1];
				curPosition++;
			}else{
				names[curPosition++] = "";
			}
			
		}
    }
    
    private int find (String name) {
		int position = 0;
		for(String nm : names){
			if(name.equalsIgnoreCase(nm)){
				return position;
			}else{
				position++;
			}
		}
		return -1;
    }
    
    public void remove (String name) {
    	
		int position = find(name);
		remove(position);	
    }

    @Override
    public String toString() {
        return "ClassList [teacherName=" + teacherName + ", names=" + Arrays.toString(names) + ", qtyNames=" + qtyNames
                + "]";
    }
    
    class DuplicateDataException extends Exception {
    	public DuplicateDataException(String str) {
    		super(str);
    	}
    }
    
    

}