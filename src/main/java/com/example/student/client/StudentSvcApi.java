package com.example.student.client;

import java.util.Collection;

import com.example.student.repository.Student;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * This interface defines an API for a StudentSvc. The
 * interface is used to prostudent a contract for client/server
 * interactions. The interface is annotated with Retrofit
 * annotations so that clients can automatically convert the
 * 
 * 
 * @author jules
 *
 */
public interface StudentSvcApi {
	
	public static final String NAME_PARAMETER = "name";
	
	public static final String DURATION_PARAMETER = "duration";

	// The path where we expect the StudentSvc to live
	public static final String STUDENT_SVC_PATH = "/student";

	// The path to search studentos by title
	public static final String STUDENT_TITLE_SEARCH_PATH = STUDENT_SVC_PATH + "/search/findByName";
	
	// The path to search studentos by title
	public static final String STUDENT_DURATION_SEARCH_PATH = STUDENT_SVC_PATH + "/search/findByDurationLessThan";

	@GET(STUDENT_SVC_PATH)
	public Collection<Student> getStudentList();
	
	@POST(STUDENT_SVC_PATH)
	public Void addStudent(@Body Student v);
	
	@GET(STUDENT_TITLE_SEARCH_PATH)
	public Collection<Student> findByTitle(@Query(NAME_PARAMETER) String title);
	
	@GET(STUDENT_DURATION_SEARCH_PATH)
	public Collection<Student> findByDurationLessThan(@Query(DURATION_PARAMETER) String title);
	
}
