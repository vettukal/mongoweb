package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.example.student.client.StudentSvcApi;
import com.example.student.repository.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.JacksonConverter;
import scala.annotation.meta.setter;

/**
 * 
 * This integration test sends a POST request to the VideoServlet to add a new video 
 * and then sends a second GET request to check that the video showed up in the list
 * of videos. Actual network communication using HTTP is performed with this test.
 * 
 * The test requires that the VideoSvc be running first (see the directions in
 * the README.md file for how to launch the Application).
 * 
 * To run this test, right-click on it in Eclipse and select
 * "Run As"->"JUnit Test"
 * 
 * Pay attention to how this test that actually uses HTTP and the test that just
 * directly makes method calls on a VideoSvc object are essentially identical.
 * All that changes is the setup of the videoService variable. Yes, this could
 * be refactored to eliminate code duplication...but the goal was to show how
 * much Retrofit simplifies interaction with our service!
 * 
 * @author jules
 *
 */
public class StudentSvcClientApiTest {

	private final String TEST_URL = "http://localhost:80";
	
	JacksonConverter converter = new JacksonConverter(new ObjectMapper() );
	
	RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(TEST_URL)
			.setConverter(converter)
			.setLogLevel(LogLevel.FULL).build();
	
	private StudentSvcApi studentService = restAdapter.create(StudentSvcApi.class);

	
	
	
	
	/**
	 * This test creates a Video, adds the Video to the VideoSvc, and then
	 * checks that the Video is included in the list when getVideoList() is
	 * called.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testVideoAddAndList() throws Exception {
		
		Student studentA = new Student();
		studentA.setFirstName("addvid1");
		studentA.setLastName("2dfred");
		
		// Add the video
		studentService.addStudent(studentA);
		try{
			//studentService.addStudent(studentA);
		}
		catch(Exception e){
			System.out.println("The exception happedned while adding");
		}
		
		
		// We should get back the video that we added above
		Collection<Student> students = studentService.getStudentList();
		assertTrue(students.contains(studentA));
		//assertTrue(true);
	}

}
