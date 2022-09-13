package com.Test;

import java.util.Arrays;

public class ClassList {
    private String teacherName;
    private String[] names;
    private int qtyNames;

    
	public ClassList(String teacherName) {
		this.teacherName= teacherName;
		this.names = new String[5];
		this.qtyNames = 0;
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
			throw new DuplicateDataException("Duplicate name found" + name);  //check 
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
    
	/*
	 * public void removeName (int position) throws ArrayIndexOutOfBoundsException{
	 * String s = names[position]; //auto throw ArrayIndexOutOfBoundsException
	 * System.out.println("name at position " + position + "is " + s); int
	 * curPosition = 0; for(String nm : names){ if(curPosition == position){
	 * names[curPosition] = ""; curPosition = curPosition+ 1; } else{ if(curPosition
	 * != 4) { curPosition = curPosition+ 1; } }
	 * 
	 * } }
	 */
    
    public void remove(int position) throws ArrayIndexOutOfBoundsException{
        String s = names[position]; //auto throw ArrayIndexOutOfBoundsException
		System.out.println("remove name " + s);
        int curPosition = 0;
		for(String nm : names){
			if(curPosition < position){
				curPosition = curPosition + 1;
			}else if(curPosition == position){
				names[curPosition] = "";
				names[curPosition] = names[curPosition+1];
				curPosition++;
			} else{
				if(curPosition == 4) {
					names[curPosition] = "";
				}else {
					names[curPosition] = names[curPosition+1];
					curPosition++;
				}
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