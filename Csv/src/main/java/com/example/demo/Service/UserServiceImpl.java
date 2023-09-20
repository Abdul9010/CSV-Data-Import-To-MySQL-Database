package com.example.demo.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepositroy;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositroy repository;

	@Override
	public boolean HasCSVFromar(MultipartFile file) {
		String type = "text/csv";
		if (!type.equals(file.getContentType())) {
			return false; // Return false if the content types do not match
		}
		return true;
	}

	@Override
	public void ProcessAndSaveData(MultipartFile file) {
		try {
			// 1. Call the csvToUsers method to convert CSV data to a list of User objects
			List<User> users = csvToUser(file.getInputStream());

			// 2. Save the list of User objects to the repository
			repository.saveAll(users);

		} catch (IOException e) {
			// TODO: handle exception
			// Handle IO exception, such as if there's an issue reading the file
			e.printStackTrace();
		}

	}

	// Internal method to convert CSV data to a list of User objects
	private List<User> csvToUser(InputStream inputStream) {

		// BufferedReader that reads the CSV data from the inputStream. It wraps the
		// inputStream with an InputStreamReader that uses the "UTF-8" character
		// encoding to read the data.
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
			List<User> users = new ArrayList<User>();
			List<CSVRecord> record = csvParser.getRecords();
			for (CSVRecord csvRecord : record) {
				User user = new User();
				if (csvRecord.isMapped("Count")) {
					user.setCount(Long.parseLong(csvRecord.get("Count")));
				}

				// Check and parse other fields as needed
				if (csvRecord.isMapped("Name")) {
					user.setName(csvRecord.get("Name"));
				}
				if (csvRecord.isMapped("Mobile")) {
					user.setMobile((csvRecord.get("Mobile")));
				}
				if (csvRecord.isMapped("Account")) {
					user.setAccount((csvRecord.get("Account")));
				}
				if (csvRecord.isMapped("Branch")) {
					user.setBranch(csvRecord.get("Branch"));
				}
				if (csvRecord.isMapped("Balance")) {
					user.setBalance((csvRecord.get("Balance")));
				}
				if (csvRecord.isMapped("Year")) {
					user.setYear((csvRecord.get("Year")));
				}
				users.add(user);
				System.out.println(user);
			}
			return users;
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<User> getAll() {

		return repository.findAll();
	}

}
