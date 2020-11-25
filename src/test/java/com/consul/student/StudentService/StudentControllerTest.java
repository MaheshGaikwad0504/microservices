// package com.consul.student.StudentService;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
// import com.springboot.student.controller.StudentController;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// public class StudentControllerTest {
//
// private MockMvc mockMvc;
//
// @InjectMocks
// private StudentController studentController;
//
// @Before
// public void setup() {
// mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
// }
//
// @Test
// public void testTest() throws Exception {
//
// mockMvc.perform(MockMvcRequestBuilders.get("/test/Mahesh"))
// .andExpect(MockMvcResultMatchers.content().string("Welcome Mahesh"));
// }
// }
