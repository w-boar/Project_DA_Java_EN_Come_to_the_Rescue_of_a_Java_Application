package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Caroline
 * @version 1.0 copy data from a file (:1 string per line) without any treatment
 *          (unordered, duplications,...)
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 * @param filepath : filepath of a list of symptoms
	 **/
	private String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * read data from a file (: 1 string per line) an add them one by one to a
	 * ArrayList
	 * 
	 * @return ArrayList<String>
	 */
	@Override
	public ArrayList<String> getSymptoms() {
		ArrayList<String> symptomList = new ArrayList<String>();
		BufferedReader reader = null;
		
		if (filepath != null) {
			try {
				reader = new BufferedReader(new FileReader(filepath));
				String symptom = reader.readLine();

				while (symptom != null) {
					symptomList.add(symptom);
					symptom = reader.readLine();
				}
				
			}
	
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return symptomList;
	}
}